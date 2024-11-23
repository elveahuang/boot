package cc.elvea.boot.system.attachment.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.attachment.model.entity.AttachmentRelationEntity;
import cc.elvea.boot.system.attachment.repository.AttachmentRelationRepository;
import cc.elvea.boot.system.attachment.service.AttachmentRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
public class AttachmentRelationServiceImpl
        extends BaseEntityService<AttachmentRelationEntity, Long, AttachmentRelationRepository>
        implements AttachmentRelationService {
}
