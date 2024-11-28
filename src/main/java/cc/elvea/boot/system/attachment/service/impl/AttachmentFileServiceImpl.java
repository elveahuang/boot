package cc.elvea.boot.system.attachment.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.attachment.model.entity.AttachmentFileEntity;
import cc.elvea.boot.system.attachment.repository.AttachmentFileRepository;
import cc.elvea.boot.system.attachment.service.AttachmentFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
public class AttachmentFileServiceImpl
        extends BaseEntityService<AttachmentFileEntity, Long, AttachmentFileRepository>
        implements AttachmentFileService {
}
