package cc.elvea.boot.system.storage.local;

import lombok.Data;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
public class LocalStorageConfig implements Serializable {

    /**
     * 是否启用
     */
    private boolean enabled = false;

    /**
     * 存储路径
     */
    private String path = "attachment";

    /**
     * 自定义域名
     */
    private String domain = "";

}
