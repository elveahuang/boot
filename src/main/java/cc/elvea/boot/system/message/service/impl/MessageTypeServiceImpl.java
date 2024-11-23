package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseCachingEntityService;
import cc.elvea.boot.system.message.model.entity.MessageTypeEntity;
import cc.elvea.boot.system.message.repository.MessageTypeRepository;
import cc.elvea.boot.system.message.service.MessageTypeService;
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
public class MessageTypeServiceImpl
        extends BaseCachingEntityService<MessageTypeEntity, Long, MessageTypeRepository>
        implements MessageTypeService {

    @Override
    public MessageTypeEntity findByCode(String code) {
        return this.getCacheService().get(this.getCacheKeyGenerator().key(code), k -> {
            Specification<MessageTypeEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(builder.equal(root.get("code"), code));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

}
