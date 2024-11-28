package cc.elvea.boot.system.message.cache;

import cc.elvea.boot.system.cache.SimpleCacheKeyGenerator;
import cc.elvea.boot.system.commons.constants.SystemCacheConstants;

/**
 * @author elvea
 * @since 24.1.0
 */
public class MessageTypeCacheKeyGenerator extends SimpleCacheKeyGenerator {

    public MessageTypeCacheKeyGenerator() {
        super(SystemCacheConstants.MESSAGE_TYPE);
    }

}
