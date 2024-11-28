package cc.elvea.boot.system.storage;

import cc.elvea.boot.system.storage.local.LocalStorageConfig;
import cc.elvea.boot.system.storage.local.LocalStorageService;
import cc.elvea.boot.system.storage.local.LocalStorageServiceImpl;
import cc.elvea.boot.system.storage.min.MinStorageConfig;
import cc.elvea.boot.system.storage.min.MinStorageService;
import cc.elvea.boot.system.storage.min.MinStorageServiceImpl;

import static cc.elvea.boot.commons.enums.StorageTypeEnum.MIN;

/**
 * @author elvea
 * @since 24.1.0
 */
public record StorageManager(StorageConfig config) {

    public StorageService getStorageService() {
        if (MIN.equals(this.config.getType())) {
            return getMinStorageService();
        }
        return getLocalStorageService();
    }

    public MinStorageService getMinStorageService() {
        return this.getMinStorageService(this.config.getMin());
    }

    public MinStorageService getMinStorageService(MinStorageConfig config) {
        return new MinStorageServiceImpl(config);
    }

    public LocalStorageService getLocalStorageService() {
        return this.getLocalStorageService(this.config.getLocal());
    }

    public LocalStorageService getLocalStorageService(LocalStorageConfig config) {
        return new LocalStorageServiceImpl(config);
    }

}
