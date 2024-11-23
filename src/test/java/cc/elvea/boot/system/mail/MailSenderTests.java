package cc.elvea.boot.system.mail;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.configuration.properties.TestProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MailSenderTests extends BaseTests {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private TestProperties testProperties;

    @Test
    void baseTest() throws Exception {
        MailBody mailBody = MailBody.builder()
                .subject("Welcome")
                .content("Hello World!")
                .to(testProperties.getEmail())
                .build();
        this.mailSender.send(mailBody);
    }

}
