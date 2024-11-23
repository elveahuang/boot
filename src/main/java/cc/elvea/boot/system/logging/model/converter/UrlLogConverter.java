package cc.elvea.boot.system.logging.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.logging.domain.UrlLogDto;
import cc.elvea.boot.system.logging.model.entity.UrlLogEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface UrlLogConverter extends Converter {

    UrlLogEntity dto2Entity(UrlLogDto dto);

}
