package cc.elvea.boot.commons.repository;

import cc.elvea.boot.commons.domain.IdEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T extends IdEntity, K extends Serializable> extends SimpleJpaRepository<T, K>
        implements BaseRepository<T, K> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, K> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager), entityManager);
        this.entityManager = entityManager;
    }

    /**
     * @see BaseRepository#getEntityManager()
     */
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
