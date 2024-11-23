package cc.elvea.boot.system.attachment.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.attachment.model.entity.AttachmentFileEntity;
import cc.elvea.boot.system.attachment.repository.AttachmentFileRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AttachmentFileService extends EntityService<AttachmentFileEntity, Long, AttachmentFileRepository> {
}
