package cc.elvea.boot.security.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.security.model.entity.ClientEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface ClientRepository extends BaseRepository<ClientEntity, Long> {
}
