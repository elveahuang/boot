package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.CachingEntityService;
import cc.elvea.boot.system.message.model.entity.MessageTypeEntity;
import cc.elvea.boot.system.message.repository.MessageTypeRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageTypeService extends CachingEntityService<MessageTypeEntity, Long, MessageTypeRepository> {

    MessageTypeEntity findByCode(String key);

}
