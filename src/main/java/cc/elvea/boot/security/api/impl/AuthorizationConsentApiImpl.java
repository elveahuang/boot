package cc.elvea.boot.security.api.impl;

import cc.elvea.boot.security.api.AuthorizationConsentApi;
import cc.elvea.boot.security.model.dto.AuthorizationConsentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
@AllArgsConstructor
public class AuthorizationConsentApiImpl implements AuthorizationConsentApi {

    /**
     * @see AuthorizationConsentApi#save(AuthorizationConsentDto)
     */
    @Override
    public void save(AuthorizationConsentDto saveDto) {
    }

    /**
     * @see AuthorizationConsentApi#deleteByKey(String, String)
     */
    @Override
    public void deleteByKey(String clientId, String principalName) {
    }

    /**
     * @see AuthorizationConsentApi#findByKey(String, String)
     */
    @Override
    public AuthorizationConsentDto findByKey(String clientId, String principalName) {
        return null;
    }

}
