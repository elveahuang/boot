package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.core.model.entity.AuthorityEntity;
import cc.elvea.boot.system.core.repository.AuthorityRepository;
import cc.elvea.boot.system.core.service.AuthorityService;
import cc.elvea.boot.system.core.service.RoleAuthorityService;
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
public class AuthorityServiceImpl extends BaseEntityService<AuthorityEntity, Long, AuthorityRepository> implements AuthorityService {

    private final RoleAuthorityService roleAuthorityService;

    private final UserRoleService userRoleService;

    public AuthorityServiceImpl(RoleAuthorityService roleAuthorityService, UserRoleService userRoleService) {
        this.roleAuthorityService = roleAuthorityService;
        this.userRoleService = userRoleService;
    }

    /**
     * @see AuthorityService#findByUserId(Long)
     */
    @Override
    public List<AuthorityEntity> findByUserId(Long userId) {
        List<AuthorityEntity> authorityList = Lists.newArrayList();

        List<Long> userRoleIdList = this.userRoleService.findRoleIdByUserId(userId);
        List<Long> userAuthorityIdList = this.roleAuthorityService.findAuthorityIdByRoleId(userRoleIdList);
        if (CollectionUtils.isNotEmpty(userAuthorityIdList)) {
            authorityList.addAll(this.findByIds(userAuthorityIdList));
        }
        return authorityList;
    }

}
