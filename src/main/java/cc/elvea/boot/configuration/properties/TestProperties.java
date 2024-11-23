package cc.elvea.boot.configuration.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(TestProperties.PREFIX)
public class TestProperties {

    public static final String PREFIX = "app.test";

    private boolean enabled = false;

    private String email;

    private String mobile;

}
