package cc.elvea.boot.system.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheKey {

    @NonNull
    private String key;

    @NonNull
    private Duration expire;

}
