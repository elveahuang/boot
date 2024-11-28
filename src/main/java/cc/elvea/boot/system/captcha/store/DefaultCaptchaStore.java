package cc.elvea.boot.system.captcha.store;

import cc.elvea.boot.system.cache.CacheKeyGenerator;
import cc.elvea.boot.system.cache.CacheService;
import cc.elvea.boot.system.cache.SimpleCacheKeyGenerator;
import cc.elvea.boot.system.captcha.Captcha;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
public class DefaultCaptchaStore implements CaptchaStore {

    private final CacheKeyGenerator cacheKeyGenerator;

    private final CacheService cacheService;

    public DefaultCaptchaStore(CacheService cacheService, String cacheKeyPrefix) {
        this.cacheKeyGenerator = SimpleCacheKeyGenerator.builder().prefix(cacheKeyPrefix).build();
        this.cacheService = cacheService;
    }

    @Override
    public Captcha get(String key) {
        return this.cacheService.get(this.cacheKeyGenerator.key(key));
    }

    @Override
    public void set(String key, Captcha value, Duration duration) {
        this.cacheService.set(this.cacheKeyGenerator.key(key), value, duration);
    }

    @Override
    public void remove(String key) {
        this.cacheService.expire(key, Duration.ofSeconds(0));
    }

}
