package cc.elvea.boot.system.core.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;
import cc.elvea.boot.system.core.model.entity.UserSessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface UserSessionConverter extends Converter {

    @Mapping(target = "actionType", ignore = true)
    UserSessionDto entity2Dto(UserSessionEntity entity);

    UserSessionEntity dto2Entity(UserSessionDto dto);

}
