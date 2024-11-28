package cc.elvea.boot.system.storage.min;

import cc.elvea.boot.commons.enums.StorageTypeEnum;
import cc.elvea.boot.system.storage.domain.AbstractFileObject;
import io.minio.GenericResponse;
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
public class MinFileObject extends AbstractFileObject<GenericResponse> {

    @Builder.Default
    private StorageTypeEnum storageType = StorageTypeEnum.MIN;

    private String key;

    private String url;

    private File object;

    private GenericResponse response;

}
