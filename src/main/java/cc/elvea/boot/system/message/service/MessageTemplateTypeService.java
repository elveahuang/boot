package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.MessageTemplateTypeEntity;
import cc.elvea.boot.system.message.repository.MessageTemplateTypeRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageTemplateTypeService extends EntityService<MessageTemplateTypeEntity, Long, MessageTemplateTypeRepository> {

    MessageTemplateTypeEntity findByCode(String key);

}
