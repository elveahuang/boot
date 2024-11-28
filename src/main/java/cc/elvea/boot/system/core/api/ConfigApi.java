package cc.elvea.boot.system.core.api;

import cc.elvea.boot.system.core.model.dto.ConfigDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface ConfigApi {

    ConfigDto get(String key);

    String getString(String key);

    String getString(String key, String defaultValue);

    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defaultValue);

}
