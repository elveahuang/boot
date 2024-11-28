package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.message.model.entity.MessageTemplateEntity;
import cc.elvea.boot.system.message.repository.MessageTemplateRepository;
import cc.elvea.boot.system.message.service.MessageTemplateService;
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
public class MessageTemplateServiceImpl extends BaseEntityService<MessageTemplateEntity, Long, MessageTemplateRepository> implements MessageTemplateService {

    @Override
    public MessageTemplateEntity findByType(Long typeId, Long templateTypeId) {
        Specification<MessageTemplateEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("typeId"), typeId));
            predicates.add(builder.equal(root.get("templateTypeId"), templateTypeId));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

}
