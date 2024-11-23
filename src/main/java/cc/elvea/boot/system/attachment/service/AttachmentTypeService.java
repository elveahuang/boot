package cc.elvea.boot.system.attachment.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity;
import cc.elvea.boot.system.attachment.repository.AttachmentTypeRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AttachmentTypeService extends EntityService<AttachmentTypeEntity, Long, AttachmentTypeRepository> {

    AttachmentTypeEntity findByCode(String code);

}
