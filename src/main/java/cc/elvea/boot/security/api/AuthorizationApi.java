package cc.elvea.boot.security.api;

import cc.elvea.boot.security.model.dto.AuthorizationDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AuthorizationApi {

    void save(AuthorizationDto saveDto);

    void deleteById(Long id);

    void deleteByUuid(String uuid);

    AuthorizationDto findById(Long id);

    AuthorizationDto findByUuid(String uuid);

    AuthorizationDto findByState(String state);

    AuthorizationDto findByAuthorizationCodeValue(String code);

    AuthorizationDto findByOidcIdTokenValue(String token);

    AuthorizationDto findByAccessTokenValue(String token);

    AuthorizationDto findByRefreshTokenValue(String token);

}
