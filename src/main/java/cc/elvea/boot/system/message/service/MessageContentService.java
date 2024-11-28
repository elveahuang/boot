package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.MessageContentEntity;
import cc.elvea.boot.system.message.repository.MessageContentRepository;

import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MessageContentService extends EntityService<MessageContentEntity, Long, MessageContentRepository> {

    List<MessageContentEntity> findByMessage(Long messageId);

    void success(Long id, String resp);

    void fail(Long id, String resp);

    void fail(Long id, String resp, String exception);

}
