package cc.elvea.boot.configuration.properties;

import cc.elvea.boot.commons.enums.StorageTypeEnum;
import cc.elvea.boot.system.storage.local.LocalStorageConfig;
import cc.elvea.boot.system.storage.min.MinStorageConfig;
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
@ConfigurationProperties(prefix = StorageProperties.PREFIX)
public class StorageProperties {

    public static final String PREFIX = "app.storage";

    private boolean enabled = true;

    private StorageTypeEnum type = StorageTypeEnum.LOCAL;

    @NestedConfigurationProperty
    private MinStorageConfig min = new MinStorageConfig();

    @NestedConfigurationProperty
    private LocalStorageConfig local = new LocalStorageConfig();

}
