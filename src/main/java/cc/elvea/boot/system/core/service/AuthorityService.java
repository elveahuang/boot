package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.entity.AuthorityEntity;
import cc.elvea.boot.system.core.repository.AuthorityRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AuthorityService extends EntityService<AuthorityEntity, Long, AuthorityRepository> {

    List<AuthorityEntity> findByUserId(Long userId);

}
