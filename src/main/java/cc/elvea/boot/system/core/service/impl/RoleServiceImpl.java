package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.core.model.entity.RoleEntity;
import cc.elvea.boot.system.core.repository.RoleRepository;
import cc.elvea.boot.system.core.service.RoleService;
import cc.elvea.boot.system.core.service.UserRoleService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
public class RoleServiceImpl extends BaseEntityService<RoleEntity, Long, RoleRepository> implements RoleService {

    private final UserRoleService userRoleService;

    public RoleServiceImpl(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public List<RoleEntity> findByUserId(Long userId) {
        List<RoleEntity> roleEntityList = Lists.newArrayList();
        List<Long> userRoleIdList = this.userRoleService.findRoleIdByUserId(userId);
        if (CollectionUtils.isNotEmpty(userRoleIdList)) {
            roleEntityList.addAll(this.findByIds(userRoleIdList));
        }
        return roleEntityList;
    }

}
