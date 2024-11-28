package cc.elvea.boot.security.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.SecurityUtils;
import cc.elvea.boot.security.model.entity.AuthorizationEntity;
import cc.elvea.boot.security.model.entity.AuthorizationEntity_;
import cc.elvea.boot.security.repository.AuthorizationRepository;
import cc.elvea.boot.security.service.AuthorizationService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
public class AuthorizationServiceImpl extends BaseEntityService<AuthorizationEntity, Long, AuthorizationRepository> implements AuthorizationService {

    @Override
    public void updateByUuid(AuthorizationEntity entity) {
        Specification<AuthorizationEntity> spec = (root, query, builder) -> builder.equal(root.get(AuthorizationEntity_.UUID), entity.getUuid());
        List<AuthorizationEntity> entityList = this.repository.findAll(spec);
        if (CollectionUtils.isNotEmpty(entityList)) {
            entityList = entityList.stream().peek((e) -> ObjectUtils.copyNotNullProperties(entity, e)).toList();
            this.saveBatch(entityList);
        } else {
            this.save(entity);
        }
    }

    @Override
    public void deleteByUuid(String uuid) {
        AuthorizationEntity entity = this.findByUuid(uuid);
        if (entity != null) {
            entity.setActive(Boolean.FALSE);
            entity.setDeletedAt(getCurLocalDateTime());
            entity.setDeletedBy(SecurityUtils.getUid());
        }
        this.save(entity);
    }

    @Override
    public AuthorizationEntity findByUuid(String uuid) {
        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.UUID), uuid));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    @Override
    public AuthorizationEntity findByState(String state) {

        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.STATE), state));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);

    }

    @Override
    public AuthorizationEntity findByAuthorizationCodeValue(String authorizationCodeValue) {
        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.AUTHORIZATION_CODE_VALUE), authorizationCodeValue));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    @Override
    public AuthorizationEntity findByOidcIdTokenValue(String oidcIdTokenValue) {

        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.OIDC_ID_TOKEN_VALUE), oidcIdTokenValue));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    @Override
    public AuthorizationEntity findByAccessTokenValue(String accessTokenValue) {
        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.ACCESS_TOKEN_VALUE), accessTokenValue));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    @Override
    public AuthorizationEntity findByRefreshTokenValue(String refreshTokenValue) {
        Specification<AuthorizationEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationEntity_.REFRESH_TOKEN_VALUE), refreshTokenValue));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

}
