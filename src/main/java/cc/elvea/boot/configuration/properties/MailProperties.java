package cc.elvea.boot.configuration.properties;

import cc.elvea.boot.system.mail.MailServer;
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
@ConfigurationProperties(MailProperties.PREFIX)
public class MailProperties {

    public static final String PREFIX = "app.mail";

    private boolean enabled = false;

    @NestedConfigurationProperty
    private MailServer server = new MailServer();

}
