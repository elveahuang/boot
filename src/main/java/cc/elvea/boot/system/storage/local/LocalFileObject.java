package cc.elvea.boot.system.storage.local;

import cc.elvea.boot.commons.enums.StorageTypeEnum;
import cc.elvea.boot.system.storage.domain.AbstractFileObject;
import lombok.*;

import java.io.File;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LocalFileObject extends AbstractFileObject<LocalResponse> {

    @Builder.Default
    private StorageTypeEnum storageType = StorageTypeEnum.LOCAL;

    private String key;

    private String url;

    private File object;

    private LocalResponse response;

}
