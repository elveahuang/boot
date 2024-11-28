package cc.elvea.boot.security.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.security.model.dto.ClientDto;
import cc.elvea.boot.security.model.entity.ClientEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface ClientConverter extends Converter {

    ClientDto entity2Dto(ClientEntity entity);

}
