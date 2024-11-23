package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.core.model.entity.UserRoleEntity;
import cc.elvea.boot.system.core.repository.UserRoleRepository;
import cc.elvea.boot.system.core.service.UserRoleService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
public class UserRoleServiceImpl extends BaseEntityService<UserRoleEntity, Long, UserRoleRepository> implements UserRoleService {

    /**
     * @see UserRoleService#findByUserId(Long)
     */
    @Override
    public List<UserRoleEntity> findByUserId(Long userId) {
        UserRoleEntity example = UserRoleEntity.builder().userId(userId).build();
        List<UserRoleEntity> entities = this.repository.findAll(Example.of(example));
        return (CollectionUtils.isNotEmpty(entities)) ? entities : Collections.emptyList();
    }

    /**
     * @see UserRoleService#findRoleIdByUserId(Long)
     */
    @Override
    public List<Long> findRoleIdByUserId(Long userId) {
        return this.findByUserId(userId).stream().map(UserRoleEntity::getRoleId).collect(Collectors.toList());
    }

}
