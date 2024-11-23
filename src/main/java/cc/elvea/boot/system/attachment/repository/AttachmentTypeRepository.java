package cc.elvea.boot.system.attachment.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface AttachmentTypeRepository extends BaseRepository<AttachmentTypeEntity, Long> {
}
