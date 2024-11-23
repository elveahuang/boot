package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.enums.MessageStatusEnum;
import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.message.model.entity.MessageEntity;
import cc.elvea.boot.system.message.repository.MessageRepository;
import cc.elvea.boot.system.message.service.MessageService;
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
public class MessageServiceImpl extends BaseEntityService<MessageEntity, Long, MessageRepository> implements MessageService {

    @Override
    public List<MessageEntity> findByStatus(final List<MessageStatusEnum> statusList) {
        Specification<MessageEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(statusList)) {
                List<Integer> statusValueList = statusList.stream().map(MessageStatusEnum::getValue).toList();
                predicates.add(root.get("status").in(statusValueList));
            }
            predicates.add(builder.equal(root.get("active"), Boolean.TRUE));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findAll(specification);
    }

}
