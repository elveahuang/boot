package cc.elvea.boot.system.logging.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.captcha.domain.CaptchaLogDto;
import cc.elvea.boot.system.logging.model.entity.CaptchaLogEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface CaptchaLogConverter extends Converter {

    CaptchaLogEntity dto2Entity(CaptchaLogDto dto);

}
