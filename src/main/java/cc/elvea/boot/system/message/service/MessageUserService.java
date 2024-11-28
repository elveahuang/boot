package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.dto.MessageRecipientDto;
import cc.elvea.boot.system.message.model.dto.MessageSenderDto;
import cc.elvea.boot.system.message.model.entity.MessageUserEntity;
import cc.elvea.boot.system.message.repository.MessageUserRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageUserService extends EntityService<MessageUserEntity, Long, MessageUserRepository> {
    /**
     * 获取消息用户
     */
    List<MessageUserEntity> findByMessage(Long messageId);

    /**
     * 获取消息发送人
     */
    MessageSenderDto getSender(Long id);

    /**
     * 获取消息发送人
     */
    MessageSenderDto getSender(MessageUserEntity entity);

    /**
     * 获取消息收件人
     */
    MessageRecipientDto getRecipient(Long id);

    /**
     * 获取消息收件人
     */
    MessageRecipientDto getRecipient(MessageUserEntity entity);
}
