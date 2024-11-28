package cc.elvea.boot.configuration;

import cc.elvea.boot.configuration.properties.StorageProperties;
import cc.elvea.boot.system.storage.StorageConfig;
import cc.elvea.boot.system.storage.StorageManager;
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
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = StorageProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class StorageConfiguration {

    public StorageConfiguration(StorageProperties properties) {
        log.info("StorageAutoConfiguration is enabled.");
        log.info("Current Storage is {}", properties.getType());
        log.info("Min Storage is {}", properties.getMin().isEnabled());
        log.info("Local Storage is {}", properties.getLocal().isEnabled());
    }

    @Bean
    public StorageManager storageManager(StorageProperties properties) {
        StorageConfig config = StorageConfig.builder()
                .type(properties.getType())
                .local(properties.getLocal())
                .min(properties.getMin())
                .build();
        return new StorageManager(config);
    }

}
