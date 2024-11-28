package cc.elvea.boot.system.mail;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MailSender {

    void send(MailBody body) throws Exception;

    void send(MailServer config, MailBody body) throws Exception;

}
