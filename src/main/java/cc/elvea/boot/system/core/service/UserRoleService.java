package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.entity.UserRoleEntity;
import cc.elvea.boot.system.core.repository.UserRoleRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UserRoleService extends EntityService<UserRoleEntity, Long, UserRoleRepository> {

    /**
     * @param userId 用户ID
     * @return 用户角色关联
     */
    List<UserRoleEntity> findByUserId(Long userId);

    /**
     * @param userId 用户ID
     * @return 角色ID
     */
    List<Long> findRoleIdByUserId(Long userId);

}
