package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.message.model.entity.MessageHistoryEntity;
import cc.elvea.boot.system.message.repository.MessageHistoryRepository;
import cc.elvea.boot.system.message.service.MessageHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@AllArgsConstructor
@Service
public class MessageHistoryServiceImpl extends BaseEntityService<MessageHistoryEntity, Long, MessageHistoryRepository> implements MessageHistoryService {
}
