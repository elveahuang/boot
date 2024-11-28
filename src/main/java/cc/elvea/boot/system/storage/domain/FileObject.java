package cc.elvea.boot.system.storage.domain;

import cc.elvea.boot.commons.enums.StorageTypeEnum;

import java.io.File;
import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface FileObject<R> extends Serializable {

    /**
     * 存储类型
     */
    StorageTypeEnum getStorageType();

    /**
     * 文件标识
     */
    String getKey();

    /**
     * 文件链接
     */
    String getUrl();

    /**
     * 文件对象
     */
    File getObject();

    /**
     * 服务响应
     */
    R getResponse();

}
