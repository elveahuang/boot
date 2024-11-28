package cc.elvea.boot.system.attachment.model.converter;

import cc.elvea.boot.commons.mapstruct.Converter;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity;
import cc.elvea.boot.system.attachment.model.vo.AttachmentTypeVo;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author elvea
 * @since 24.1.0
 */
@Mapper(componentModel = SPRING)
public interface AttachmentTypeConverter extends Converter {

    AttachmentTypeVo entity2Vo(AttachmentTypeEntity entity);

}
