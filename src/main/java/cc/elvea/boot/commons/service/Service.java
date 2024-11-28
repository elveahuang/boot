package cc.elvea.boot.commons.service;

import java.time.LocalDateTime;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface Service {

    /**
     * 获取当前系统时间
     */
    default LocalDateTime getCurLocalDateTime() {
        return LocalDateTime.now();
    }

}
