package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.entity.RoleAuthorityEntity;
import cc.elvea.boot.system.core.repository.RoleAuthorityRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface RoleAuthorityService extends EntityService<RoleAuthorityEntity, Long, RoleAuthorityRepository> {

    /**
     * @param roleIdList 角色ID
     * @return 角色权限关联
     */
    List<RoleAuthorityEntity> findByRoleId(List<Long> roleIdList);

    /**
     * @param roleIdList 角色ID
     * @return 权限ID
     */
    List<Long> findAuthorityIdByRoleId(List<Long> roleIdList);

}
