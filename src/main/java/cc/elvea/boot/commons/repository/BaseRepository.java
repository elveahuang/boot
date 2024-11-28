package cc.elvea.boot.commons.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author elvea
 * @since 24.1.0
 */
@NoRepositoryBean
public interface BaseRepository<T, K> extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {

    /**
     * EntityManager
     */
    EntityManager getEntityManager();

}
