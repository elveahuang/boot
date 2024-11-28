package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.message.model.entity.MessageTemplateTypeEntity;
import cc.elvea.boot.system.message.repository.MessageTemplateTypeRepository;
import cc.elvea.boot.system.message.service.MessageTemplateTypeService;
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
@Service
@AllArgsConstructor
public class MessageTemplateTypeServiceImpl extends BaseEntityService<MessageTemplateTypeEntity, Long, MessageTemplateTypeRepository> implements MessageTemplateTypeService {

    @Override
    public MessageTemplateTypeEntity findByCode(String code) {
        Specification<MessageTemplateTypeEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("code"), code));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

}
