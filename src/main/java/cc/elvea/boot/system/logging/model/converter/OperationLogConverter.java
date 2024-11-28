package cc.elvea.boot.system.logging.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.logging.domain.OperationLogDto;
import cc.elvea.boot.system.logging.model.entity.OperationLogEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface OperationLogConverter extends Converter {

    OperationLogEntity dto2Entity(OperationLogDto dto);

}
