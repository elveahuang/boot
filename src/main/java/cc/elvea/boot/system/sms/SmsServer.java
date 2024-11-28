package cc.elvea.boot.system.sms;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
public class SmsServer implements Serializable {

    @Builder.Default
    private AliyunSmsSender.ServerConfig aliyun = AliyunSmsSender.ServerConfig.builder().build();

}
