package cc.elvea.boot.system.core.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.core.model.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRoleEntity, Long> {
}