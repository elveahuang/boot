package cc.elvea.boot.security.api.impl;

import cc.elvea.boot.security.api.ClientApi;
import cc.elvea.boot.security.model.converter.ClientConverter;
import cc.elvea.boot.security.model.dto.ClientDto;
import cc.elvea.boot.security.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
@AllArgsConstructor
public class ClientApiImpl implements ClientApi {

    private final ClientService clientService;

    private final ClientConverter clientConverter;

    /**
     * @see ClientApi#save(ClientDto)
     */
    @Override
    public void save(ClientDto clientDto) {
    }

    /**
     * @see ClientApi#findById(Long)
     */
    @Override
    public ClientDto findById(Long id) {
        return clientConverter.entity2Dto(this.clientService.findById(id));
    }

    /**
     * @see ClientApi#findByClientId(String)
     */
    @Override
    public ClientDto findByClientId(String clientId) {
        return clientConverter.entity2Dto(this.clientService.findClientByClientId(clientId));
    }

}
