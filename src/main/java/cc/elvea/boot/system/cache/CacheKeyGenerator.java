package cc.elvea.boot.system.cache;

import cc.elvea.boot.commons.constants.CacheConstants;
import cc.elvea.boot.commons.utils.StringUtils;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CacheKeyGenerator {

    default String getPrefix() {
        return "";
    }

    default Duration getExpire() {
        return CacheConstants.DEFAULT_CACHE_DURATION;
    }

    default CacheKey key(Object... params) {
        String key;
        if (StringUtils.isEmpty(this.getPrefix())) {
            key = StringUtils.arrayToDelimitedString(params, "_");
        } else {
            key = String.format("%s:%s", this.getPrefix(), StringUtils.arrayToDelimitedString(params, "_"));
        }
        return new CacheKey(key, getExpire());
    }

    default CacheKey byId(Long id) {
        return this.key("id", id);
    }

}
