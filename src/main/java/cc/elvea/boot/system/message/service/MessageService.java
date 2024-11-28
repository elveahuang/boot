package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.enums.MessageStatusEnum;
import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.MessageEntity;
import cc.elvea.boot.system.message.repository.MessageRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageService extends EntityService<MessageEntity, Long, MessageRepository> {

    /**
     * 根据发送状态获取消息记录
     */
    List<MessageEntity> findByStatus(List<MessageStatusEnum> statusList);

}
