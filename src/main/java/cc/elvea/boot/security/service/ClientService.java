package cc.elvea.boot.security.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.security.model.entity.ClientEntity;
import cc.elvea.boot.security.repository.ClientRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface ClientService extends EntityService<ClientEntity, Long, ClientRepository> {

    ClientEntity findClientById(Long id);

    ClientEntity findClientByClientId(String clientId);

}
