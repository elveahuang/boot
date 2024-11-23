package cc.elvea.boot.security.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface AuthorizationConsentConverter extends Converter {
}
