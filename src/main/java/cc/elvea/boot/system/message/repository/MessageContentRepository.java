package cc.elvea.boot.system.message.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.message.model.entity.MessageContentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface MessageContentRepository extends BaseRepository<MessageContentEntity, Long> {
}
