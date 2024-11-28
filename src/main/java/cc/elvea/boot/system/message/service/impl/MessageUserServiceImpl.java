package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.message.model.dto.MessageRecipientDto;
import cc.elvea.boot.system.message.model.dto.MessageSenderDto;
import cc.elvea.boot.system.message.model.entity.MessageUserEntity;
import cc.elvea.boot.system.message.repository.MessageUserRepository;
import cc.elvea.boot.system.message.service.MessageUserService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@AllArgsConstructor
@Service
public class MessageUserServiceImpl extends BaseEntityService<MessageUserEntity, Long, MessageUserRepository> implements MessageUserService {

    @Override
    public List<MessageUserEntity> findByMessage(Long messageId) {
        Specification<MessageUserEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("messageId"), messageId));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findAll(specification);
    }

    @Override
    public MessageSenderDto getSender(Long id) {
        return this.getSender(this.findById(id));
    }

    @Override
    public MessageSenderDto getSender(MessageUserEntity entity) {
        MessageSenderDto.MessageSenderDtoBuilder builder = MessageSenderDto.builder();
        if (entity != null) {
            builder.id(entity.getUserId());
            builder.username(entity.getUsername());
            builder.email(entity.getEmail());
            builder.mobileCountryCode(entity.getMobileCountryCode());
            builder.mobileNumber(entity.getMobileNumber());
        }
        return builder.build();
    }

    @Override
    public MessageRecipientDto getRecipient(Long id) {
        return this.getRecipient(this.findById(id));
    }

    @Override
    public MessageRecipientDto getRecipient(MessageUserEntity entity) {
        MessageRecipientDto.MessageRecipientDtoBuilder builder = MessageRecipientDto.builder();
        if (entity != null) {
            builder.id(entity.getUserId());
            builder.username(entity.getUsername());
            builder.email(entity.getEmail());
            builder.mobileCountryCode(entity.getMobileCountryCode());
            builder.mobileNumber(entity.getMobileNumber());
        }
        return builder.build();
    }

}
