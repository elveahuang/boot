package cc.elvea.boot.system.storage;

import cc.elvea.boot.commons.enums.StorageTypeEnum;
import cc.elvea.boot.system.storage.local.LocalStorageConfig;
import cc.elvea.boot.system.storage.min.MinStorageConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageConfig implements Serializable {

    @Builder.Default
    private StorageTypeEnum type = StorageTypeEnum.LOCAL;

    @Builder.Default
    private MinStorageConfig min = new MinStorageConfig();

    @Builder.Default
    private LocalStorageConfig local = new LocalStorageConfig();

}
