package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.MessageHistoryEntity;
import cc.elvea.boot.system.message.repository.MessageHistoryRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageHistoryService extends EntityService<MessageHistoryEntity, Long, MessageHistoryRepository> {
}
