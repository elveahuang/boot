package cc.elvea.boot.system.cache;

import lombok.Builder;
import org.springframework.lang.NonNull;

/**
 * @author elvea
 * @since 24.1.0
 */
@Builder
public class SimpleCacheKeyGenerator implements CacheKeyGenerator {

    private String prefix;

    public SimpleCacheKeyGenerator(String prefix) {
        this.prefix = prefix;
    }

    @NonNull
    @Override
    public String getPrefix() {
        return this.prefix;
    }

}
