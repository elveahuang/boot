package cc.elvea.boot.system.core.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.core.model.dto.ConfigDto;
import cc.elvea.boot.system.core.model.entity.ConfigEntity;
import cc.elvea.boot.system.core.model.form.ConfigForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface ConfigConverter extends Converter {

    ConfigDto entityToDto(ConfigEntity entity);

    @Mapping(target = "label", ignore = true)
    @Mapping(target = "title", ignore = true)
    ConfigEntity formToEntity(ConfigForm form);

}
