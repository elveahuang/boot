package cc.elvea.boot.system.sms;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface SmsSender {

    void send(SmsBody body) throws Exception;

    void send(SmsServer config, SmsBody body) throws Exception;

}
