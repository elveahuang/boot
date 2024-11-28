package cc.elvea.boot.system.core.api.impl;

import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.core.api.ConfigApi;
import cc.elvea.boot.system.core.model.converter.ConfigConverter;
import cc.elvea.boot.system.core.model.dto.ConfigDto;
import cc.elvea.boot.system.core.service.ConfigService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
@AllArgsConstructor
public class ConfigApiImpl implements ConfigApi {

    private final ConfigService configService;

    private final ConfigConverter configConverter;

    @Override
    public ConfigDto get(String key) {
        return configConverter.entityToDto(this.configService.getConfig(key));
    }

    @Override
    public String getString(String key) {
        return this.getString(key, "");
    }

    @Override
    public String getString(String key, String defaultValue) {
        ConfigDto config = this.get(key);
        if (config != null) {
            return StringUtils.isNotEmpty(config.getConfigValue()) ? config.getConfigValue() : defaultValue;
        }
        return defaultValue;
    }

    @Override
    public boolean getBoolean(String key) {
        return this.getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        ConfigDto config = this.get(key);
        if (config != null) {
            return "true".equalsIgnoreCase(config.getConfigValue()) || "1".equalsIgnoreCase(config.getConfigValue());
        }
        return defaultValue;
    }

}
