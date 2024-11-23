package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.enums.ActionTypeEnum;
import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.core.model.converter.UserSessionConverter;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;
import cc.elvea.boot.system.core.model.entity.UserSessionEntity;
import cc.elvea.boot.system.core.repository.UserSessionRepository;
import cc.elvea.boot.system.core.service.UserSessionService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserSessionServiceImpl extends BaseEntityService<UserSessionEntity, Long, UserSessionRepository> implements UserSessionService {

    private final UserSessionConverter userSessionConverter;

    @Override
    public UserSessionEntity findBySessionId(String sessionId) {
        Specification<UserSessionEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = Lists.newArrayList();
            predicates.add(builder.equal(root.get("sessionId"), sessionId));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    @Override
    public void saveUserSession(UserSessionDto dto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        UserSessionEntity entity = this.findBySessionId(dto.getSessionId());
        if (ActionTypeEnum.DELETE.equals(dto.getActionType())) {
            if (entity != null) {
                entity.setEndDatetime(localDateTime);
                entity.setLastModifiedBy(dto.getUserId());
                entity.setLastModifiedAt(localDateTime);
                entity.setDeletedBy(dto.getUserId());
                entity.setDeletedAt(localDateTime);
                this.save(entity);
            }
        } else {
            if (entity != null) {
                entity.setLastAccessDatetime(localDateTime);
            } else {
                entity = this.userSessionConverter.dto2Entity(dto);
                entity.setStartDatetime(localDateTime);
                entity.setCreatedBy(dto.getUserId());
                entity.setCreatedAt(localDateTime);
            }
            entity.setUa(dto.getUa());
            entity.setHost(dto.getHost());
            entity.setLastAccessDatetime(localDateTime);
            entity.setLastModifiedBy(dto.getUserId());
            entity.setLastModifiedAt(localDateTime);
            this.save(entity);
        }
    }

}
