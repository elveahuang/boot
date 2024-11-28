package cc.elvea.boot.system.sms;

import cc.elvea.boot.commons.utils.JacksonUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class AliyunSmsSender implements SmsSender {

    private SmsServer server;

    @Override
    public void send(SmsBody body) throws Exception {
        this.send(this.server, body);
    }

    @Override
    public void send(SmsServer server, SmsBody body) throws Exception {
        Client client = createClient(server.getAliyun(), body);
        SendSmsRequest request = getRequest(server.getAliyun(), body);
        try {
            SendSmsResponse response = client.sendSmsWithOptions(request, new RuntimeOptions());
        } catch (TeaException error) {
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }

    @NonNull
    private static Client createClient(ServerConfig serverConfig, SmsBody body) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(serverConfig.getAccessKeyId())
                .setAccessKeySecret(serverConfig.getAccessKeySecret());
        config.setEndpoint(serverConfig.getEndpoint());
        return new Client(config);
    }

    @NonNull
    private static SendSmsRequest getRequest(ServerConfig server, SmsBody body) throws Exception {
        String template = StringUtils.isNotEmpty(body.getTemplate()) ? body.getTemplate() : server.getTemplate();

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(body.getMobileNumber());
        request.setSignName(server.getSignName());
        request.setTemplateCode(template);
        request.setTemplateParam(JacksonUtils.toJson(body.getParams()));

        return request;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServerConfig implements Serializable {
        @Builder.Default
        private boolean enabled = false;
        @Builder.Default
        private String endpoint = "dysmsapi.aliyuncs.com";
        private String accessKeyId;
        private String accessKeySecret;
        private String signName;
        private String template;
    }

}
