package cc.elvea.boot.commons.data;

import cc.elvea.boot.commons.utils.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * @author elvea
 * @since 24.1.0
 */
public class UserAuditorAware implements AuditorAware<Long> {

    /**
     * @see AuditorAware#getCurrentAuditor()
     */
    public @NonNull Optional<Long> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getUid());
    }

}
