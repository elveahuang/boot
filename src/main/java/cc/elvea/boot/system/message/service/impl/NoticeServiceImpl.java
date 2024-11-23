package cc.elvea.boot.system.message.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.SecurityUtils;
import cc.elvea.boot.system.message.model.entity.NoticeEntity;
import cc.elvea.boot.system.message.model.request.NoticeSearchRequest;
import cc.elvea.boot.system.message.repository.NoticeRepository;
import cc.elvea.boot.system.message.service.NoticeService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
public class NoticeServiceImpl extends BaseEntityService<NoticeEntity, Long, NoticeRepository> implements NoticeService {

    @Override
    public Page<NoticeEntity> findMyNoticeByUserId(NoticeSearchRequest request) {
        request.setUserId(SecurityUtils.getUid());
        Specification<NoticeEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("recipientId"), request.getUserId()));
            predicates.add(builder.equal(root.get("active"), Boolean.TRUE));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findAll(specification, request.getPageable());
    }

    @Override
    public Page<NoticeEntity> findByUserId(NoticeSearchRequest request) {
        Specification<NoticeEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (request.getUserId() != null && request.getUserId() > 0) {
                predicates.add(builder.equal(root.get("recipientId"), request.getUserId()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findAll(specification, request.getPageable());
    }

}
