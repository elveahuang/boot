package cc.elvea.boot.security.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.security.model.dto.AuthorizationDto;
import cc.elvea.boot.security.model.entity.AuthorizationEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface AuthorizationConverter extends Converter {

    AuthorizationDto entity2Dto(AuthorizationEntity entity);

    AuthorizationEntity dto2Entity(AuthorizationDto dto);

}
