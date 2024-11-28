package cc.elvea.boot.configuration.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(ArthasProperties.PREFIX)
public class ArthasProperties {

    public static final String PREFIX = "app.arthas";

    private boolean enabled = false;

    private String appName = "app";

    private String agentId = "app";

    private String tunnelServer = "ws://127.0.0.1:7777/ws";

}
