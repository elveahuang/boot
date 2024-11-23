package cc.elvea.boot.security.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.security.model.entity.AuthorizationEntity;
import cc.elvea.boot.security.repository.AuthorizationRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AuthorizationService extends EntityService<AuthorizationEntity, Long, AuthorizationRepository> {

    void updateByUuid(AuthorizationEntity entity);

    void deleteByUuid(String uuid);

    AuthorizationEntity findByUuid(String uuid);

    AuthorizationEntity findByState(String state);

    AuthorizationEntity findByAuthorizationCodeValue(String code);

    AuthorizationEntity findByOidcIdTokenValue(String token);

    AuthorizationEntity findByAccessTokenValue(String token);

    AuthorizationEntity findByRefreshTokenValue(String token);

}
