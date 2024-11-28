package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.core.model.entity.RoleAuthorityEntity;
import cc.elvea.boot.system.core.repository.RoleAuthorityRepository;
import cc.elvea.boot.system.core.service.RoleAuthorityService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
public class RoleAuthorityServiceImpl extends BaseEntityService<RoleAuthorityEntity, Long, RoleAuthorityRepository> implements RoleAuthorityService {

    /**
     * @see RoleAuthorityService#findByRoleId(List)
     */
    @Override
    public List<RoleAuthorityEntity> findByRoleId(List<Long> roleIdList) {
        List<RoleAuthorityEntity> entityList = null;
        if (CollectionUtils.isNotEmpty(roleIdList)) {
            Specification<RoleAuthorityEntity> specification = (root, query, builder) ->
                    builder.and(root.get("roleId").in(roleIdList));
            entityList = this.repository.findAll(specification);
        }
        return CollectionUtils.isNotEmpty(entityList) ? entityList : Collections.emptyList();
    }

    /**
     * @see RoleAuthorityService#findAuthorityIdByRoleId(List)
     */
    @Override
    public List<Long> findAuthorityIdByRoleId(List<Long> roleIdList) {
        return CollectionUtils.isNotEmpty(roleIdList) ?
                this.findByRoleId(roleIdList).stream().map(RoleAuthorityEntity::getAuthorityId).collect(Collectors.toList()) :
                Collections.emptyList();
    }

}
