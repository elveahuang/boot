package cc.elvea.boot.system.attachment.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.attachment.model.entity.AttachmentFileEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface AttachmentFileRepository extends BaseRepository<AttachmentFileEntity, Long> {
}
