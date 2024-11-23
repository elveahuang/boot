package cc.elvea.boot.security.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.security.model.entity.AuthorizationConsentEntity;
import cc.elvea.boot.security.model.entity.AuthorizationConsentEntity_;
import cc.elvea.boot.security.repository.AuthorizationConsentRepository;
import cc.elvea.boot.security.service.AuthorizationConsentService;
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
public class AuthorizationConsentServiceImpl
        extends BaseEntityService<AuthorizationConsentEntity, Long, AuthorizationConsentRepository>
        implements AuthorizationConsentService {

    /**
     * @see AuthorizationConsentService#findByKey(String, String)
     */
    @Override
    public AuthorizationConsentEntity findByKey(String clientId, String principalName) {
        Specification<AuthorizationConsentEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(AuthorizationConsentEntity_.CLIENT_ID), clientId));
            predicates.add(builder.equal(root.get(AuthorizationConsentEntity_.PRINCIPAL_NAME), principalName));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

    /**
     * @see AuthorizationConsentService#deleteByKey(String, String)
     */
    @Override
    public void deleteByKey(String clientId, String principalName) {
    }

}
