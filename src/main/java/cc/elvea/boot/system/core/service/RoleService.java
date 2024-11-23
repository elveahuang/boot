package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.entity.RoleEntity;
import cc.elvea.boot.system.core.repository.RoleRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface RoleService extends EntityService<RoleEntity, Long, RoleRepository> {

    List<RoleEntity> findByUserId(Long userId);

}
