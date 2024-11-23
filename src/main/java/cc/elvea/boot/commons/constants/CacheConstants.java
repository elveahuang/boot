package cc.elvea.boot.commons.constants;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CacheConstants {

    /**
     * 默认缓存周期为2个小时
     */
    Duration DEFAULT_CACHE_DURATION = Duration.ofHours(1);

    /**
     * 缓存批处理记录数
     */
    int MAX_BATCH_KEY_SIZE = 20;

}
