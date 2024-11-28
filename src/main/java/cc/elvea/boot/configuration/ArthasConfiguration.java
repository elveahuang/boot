package cc.elvea.boot.configuration;

import cc.elvea.boot.configuration.properties.ArthasProperties;
import com.taobao.arthas.agent.attach.ArthasAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@EnableAsync
@EnableAspectJAutoProxy
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({ArthasProperties.class})
public class ArthasConfiguration {

    public ArthasConfiguration(ArthasProperties properties) {
        if (properties.isEnabled()) {
            log.info("Arthas enabled.");
            log.info("Arthas appName - {}", properties.getAppName());
            log.info("Arthas agentId - {}", properties.getAgentId());
            log.info("Arthas tunnelServer - {}", properties.getTunnelServer());

            Map<String, String> configMap = new HashMap<>();
            configMap.put("arthas.appName", properties.getAppName());
            configMap.put("arthas.agentId", properties.getAgentId());
            configMap.put("arthas.tunnelServer", properties.getTunnelServer());
            ArthasAgent.attach(configMap);
        } else {
            log.info("Arthas disabled.");
        }
    }

}
