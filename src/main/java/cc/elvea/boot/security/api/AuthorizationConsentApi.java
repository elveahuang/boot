package cc.elvea.boot.security.api;

import cc.elvea.boot.security.model.dto.AuthorizationConsentDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AuthorizationConsentApi {

    void save(AuthorizationConsentDto saveDto);

    void deleteByKey(String clientId, String principalName);

    AuthorizationConsentDto findByKey(String clientId, String principalName);

}
