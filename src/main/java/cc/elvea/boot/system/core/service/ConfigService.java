package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.CachingEntityService;
import cc.elvea.boot.system.core.model.entity.ConfigEntity;
import cc.elvea.boot.system.core.model.form.ConfigForm;
import cc.elvea.boot.system.core.repository.ConfigRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface ConfigService extends CachingEntityService<ConfigEntity, Long, ConfigRepository> {

    ConfigEntity getConfig(String key);

    void saveConfig(ConfigForm form);

}
