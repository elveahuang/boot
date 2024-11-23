package cc.elvea.boot.security.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.security.model.entity.ClientEntity;
import cc.elvea.boot.security.model.entity.ClientEntity_;
import cc.elvea.boot.security.repository.ClientRepository;
import cc.elvea.boot.security.service.ClientService;
import jakarta.persistence.criteria.Predicate;
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
public class ClientServiceImpl extends BaseEntityService<ClientEntity, Long, ClientRepository> implements ClientService {

    @Override
    public ClientEntity findClientById(Long id) {
        return this.findById(id);
    }

    @Override
    public ClientEntity findClientByClientId(String clientId) {
        Specification<ClientEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get(ClientEntity_.CLIENT_ID), clientId));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return this.repository.findOne(specification).orElse(null);
    }

}
