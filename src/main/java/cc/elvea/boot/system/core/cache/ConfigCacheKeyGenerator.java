package cc.elvea.boot.system.core.cache;

import cc.elvea.boot.system.cache.SimpleCacheKeyGenerator;
import cc.elvea.boot.system.commons.constants.SystemCacheConstants;

/**
 * @author elvea
 * @since 24.1.0
 */
public class ConfigCacheKeyGenerator extends SimpleCacheKeyGenerator {

    public ConfigCacheKeyGenerator() {
        super(SystemCacheConstants.CONFIG);
    }

}
