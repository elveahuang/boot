package cc.elvea.boot.configuration.properties;

import cc.elvea.boot.system.sms.AliyunSmsSender;
import cc.elvea.boot.system.sms.SmsServerType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(SmsProperties.PREFIX)
public class SmsProperties {

    public static final String PREFIX = "app.sms";

    private boolean enabled = false;

    private SmsServerType type = SmsServerType.Aliyun;

    @NestedConfigurationProperty
    private AliyunSmsSender.ServerConfig aliyun = AliyunSmsSender.ServerConfig.builder().build();

}
