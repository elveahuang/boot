package cc.elvea.boot.system.storage.local;

import cc.elvea.boot.system.storage.StorageService;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface LocalStorageService extends StorageService {

    /**
     * 获取存储路径
     */
    String getPath();

    /**
     * 自定义域名
     */
    String getDomain();

}
