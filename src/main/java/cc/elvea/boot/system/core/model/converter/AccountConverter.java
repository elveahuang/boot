package cc.elvea.boot.system.core.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.core.model.dto.AccountDto;
import cc.elvea.boot.system.core.model.dto.AccountInfoDto;
import cc.elvea.boot.system.core.model.dto.AccountLoginInfoDto;
import cc.elvea.boot.system.core.model.dto.UserInfoDto;
import cc.elvea.boot.system.core.model.entity.AccountEntity;
import cc.elvea.boot.system.core.model.form.AccountForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface AccountConverter extends Converter {

    @Mapping(target = "organizations", ignore = true)
    @Mapping(target = "positions", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    AccountLoginInfoDto entity2LoginInfoDto(AccountEntity entity);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    AccountInfoDto entity2InfoDto(AccountEntity entity);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "mobileCountryCode", ignore = true)
    @Mapping(target = "mobileNumber", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    UserInfoDto entity2BaseUserInfoDto(AccountEntity entity);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "mobileCountryCode", ignore = true)
    @Mapping(target = "mobileNumber", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    AccountDto entity2BaseUserInfoDtoNotHaveEmail(AccountEntity entity);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "mobileCountryCode", ignore = true)
    @Mapping(target = "mobileNumber", ignore = true)
    @Mapping(target = "idCardType", ignore = true)
    @Mapping(target = "idCardNo", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "passwordExpireAt", ignore = true)
    @Mapping(target = "passwordErrorAt", ignore = true)
    @Mapping(target = "passwordErrorCount", ignore = true)
    @Mapping(target = "lastLoginStatus", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    AccountEntity formToEntity(AccountForm form);

}