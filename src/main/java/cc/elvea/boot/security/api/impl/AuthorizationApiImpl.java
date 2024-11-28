package cc.elvea.boot.security.api.impl;

import cc.elvea.boot.security.api.AuthorizationApi;
import cc.elvea.boot.security.model.converter.AuthorizationConverter;
import cc.elvea.boot.security.model.dto.AuthorizationDto;
import cc.elvea.boot.security.model.entity.AuthorizationEntity;
import cc.elvea.boot.security.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
@AllArgsConstructor
public class AuthorizationApiImpl implements AuthorizationApi {

    private final AuthorizationConverter authorizationConverter;

    private final AuthorizationService authorizationService;

    /**
     * @see AuthorizationApi#save(AuthorizationDto)
     */
    @Override
    public void save(AuthorizationDto dto) {
        AuthorizationEntity entity = this.authorizationConverter.dto2Entity(dto);
        this.authorizationService.updateByUuid(entity);
    }

    /**
     * @see AuthorizationApi#deleteById(Long)
     */
    @Override
    public void deleteById(Long id) {
        this.authorizationService.deleteById(id);
    }

    /**
     * @see AuthorizationApi#deleteByUuid(String)
     */
    @Override
    public void deleteByUuid(String uuid) {
        this.authorizationService.deleteByUuid(uuid);
    }

    /**
     * @see AuthorizationApi#findById(Long)
     */
    @Override
    public AuthorizationDto findById(Long id) {
        AuthorizationEntity entity = this.authorizationService.findById(id);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByUuid(String)
     */
    @Override
    public AuthorizationDto findByUuid(String uuid) {
        AuthorizationEntity entity = this.authorizationService.findByUuid(uuid);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByState(String)
     */
    @Override
    public AuthorizationDto findByState(String state) {
        AuthorizationEntity entity = this.authorizationService.findByState(state);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByAuthorizationCodeValue(String)
     */
    @Override
    public AuthorizationDto findByAuthorizationCodeValue(String code) {
        AuthorizationEntity entity = this.authorizationService.findByAuthorizationCodeValue(code);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByOidcIdTokenValue(String)
     */
    @Override
    public AuthorizationDto findByOidcIdTokenValue(String token) {
        AuthorizationEntity entity = this.authorizationService.findByOidcIdTokenValue(token);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByAccessTokenValue(String)
     */
    @Override
    public AuthorizationDto findByAccessTokenValue(String token) {
        AuthorizationEntity entity = this.authorizationService.findByAccessTokenValue(token);
        return this.authorizationConverter.entity2Dto(entity);
    }

    /**
     * @see AuthorizationApi#findByRefreshTokenValue(String)
     */
    @Override
    public AuthorizationDto findByRefreshTokenValue(String token) {
        AuthorizationEntity entity = this.authorizationService.findByRefreshTokenValue(token);
        return this.authorizationConverter.entity2Dto(entity);
    }

}
