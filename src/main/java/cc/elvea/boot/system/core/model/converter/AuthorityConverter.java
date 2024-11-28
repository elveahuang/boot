package cc.elvea.boot.system.core.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.core.model.dto.AuthorityDto;
import cc.elvea.boot.system.core.model.entity.AuthorityEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface AuthorityConverter extends Converter {

    List<AuthorityDto> entityListToDtoList(List<AuthorityEntity> entityList);

}
