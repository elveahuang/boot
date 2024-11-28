package cc.elvea.boot.system.storage.domain;

import cc.elvea.boot.commons.enums.FileAccessTypeEnum;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileParameter implements Serializable {

    /**
     * 媒体类型
     */
    private String contentType;

    /**
     * 原始文件名
     */
    private String originalFilename;

    /**
     * 目标文件名
     */
    private String filename;

    /**
     * 文件大小
     */
    private long size;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 存储标识
     */
    private String key;

    /**
     * 访问类型
     */
    private FileAccessTypeEnum accessType;

    public static FileParameter.FileParameterBuilder withPublic() {
        return FileParameter.builder().accessType(FileAccessTypeEnum.PUBLIC);
    }

    public static FileParameter.FileParameterBuilder withPrivate() {
        return FileParameter.builder().accessType(FileAccessTypeEnum.PRIVATE);
    }

    public static FileParameter withDefault() {
        return FileParameter.withPublic().build();
    }

}
