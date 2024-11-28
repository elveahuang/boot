package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.MessageTemplateEntity;
import cc.elvea.boot.system.message.repository.MessageTemplateRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageTemplateService extends EntityService<MessageTemplateEntity, Long, MessageTemplateRepository> {

    MessageTemplateEntity findByType(Long typeId, Long templateTypeId);

}
