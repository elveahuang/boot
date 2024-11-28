package cc.elvea.boot.commons.service;

import java.time.LocalDateTime;

/**
 * @author elvea
 * @since 24.1.0
 */
public abstract class AbstractService implements Service {

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

}
