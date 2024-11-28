package cc.elvea.boot.configuration;

import cc.elvea.boot.configuration.properties.MailProperties;
import cc.elvea.boot.system.mail.MailSender;
import cc.elvea.boot.system.mail.SpringMailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({MailProperties.class})
@ConditionalOnProperty(prefix = MailProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class MailConfiguration {

    public MailConfiguration(MailProperties properties) {
        log.info("MailConfiguration is enabled.");
        log.info("Mail Server is {}", properties.getServer().isEnabled());
    }

    @Bean
    public MailSender mailSender(MailProperties properties) {
        return new SpringMailSender(properties.getServer());
    }

}
