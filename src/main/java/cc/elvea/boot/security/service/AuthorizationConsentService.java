package cc.elvea.boot.security.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.security.model.entity.AuthorizationConsentEntity;
import cc.elvea.boot.security.repository.AuthorizationConsentRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AuthorizationConsentService extends EntityService<AuthorizationConsentEntity, Long, AuthorizationConsentRepository> {

    AuthorizationConsentEntity findByKey(String clientId, String principalName);

    void deleteByKey(String clientId, String principalName);

}
