package cc.elvea.boot.system.mail;

import cc.elvea.boot.commons.constants.GlobalConstants;
import cc.elvea.boot.commons.enums.SslProtocolTypeEnum;
import cc.elvea.boot.commons.utils.StringUtils;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

/**
 * @author elvea
 * @since 24.1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class SpringMailSender implements MailSender {

    private MailServer server;

    @Override
    public void send(MailBody body) throws Exception {
        this.send(this.server, body);
    }

    @Override
    public void send(MailServer server, MailBody body) throws Exception {
        JavaMailSender sender = getJavaMailSender(server);

        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        // 发件人
        // 邮件服务器基本都要求发件人必须和链接的账号一致
        if (StringUtils.isNotEmpty(server.getName())) {
            helper.setFrom(new InternetAddress(server.getFrom(), server.getName()));
        } else {
            helper.setFrom(server.getFrom());
        }
        // 收件人
        helper.setTo(body.getTo());
        // 标题
        helper.setSubject(body.getSubject());
        // 内容
        helper.setText(body.getContent(), true);
        // 发送邮件
        sender.send(msg);
    }

    JavaMailSender getJavaMailSender(MailServer server) {
        int port = server.getPort() <= 0 ? GlobalConstants.DEFAULT_SMTP_PORT : server.getPort();

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding(GlobalConstants.ENCODING);
        mailSender.setHost(server.getHost());
        mailSender.setPort(port);
        if (server.isAuth()) {
            mailSender.setUsername(server.getUsername());
            mailSender.setPassword(server.getPassword());
        }
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", String.valueOf(server.isAuth()));
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.timeout", "25000");
        properties.setProperty("mail.smtp.port", String.valueOf(port));
        if (server.isSsl()) {
            // 启用安全连接
            if (SslProtocolTypeEnum.STARTTLS.equals(server.getSslProtocol())) {
                // StartTLS
                properties.setProperty("mail.smtp.starttls.enable", "true");
                properties.setProperty("mail.smtp.socketFactory.port", String.valueOf(port));
                properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            } else {
                // SSL
                properties.setProperty("mail.smtp.ssl.enable", "true");
                properties.setProperty("mail.smtp.ssl.trust", server.getHost());
                properties.setProperty("mail.smtp.socketFactory.port", String.valueOf(port));
                properties.setProperty("mail.smtp.socketFactory.fallback", "false");
                properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            }
        }
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

}
