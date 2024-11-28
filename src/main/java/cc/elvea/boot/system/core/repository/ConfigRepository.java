package cc.elvea.boot.system.core.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.core.model.entity.ConfigEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface ConfigRepository extends BaseRepository<ConfigEntity, Long> {
}
