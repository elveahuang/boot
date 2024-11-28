package cc.elvea.boot.commons.service;

import cc.elvea.boot.commons.domain.IdEntity;
import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.cache.CacheKeyGenerator;
import cc.elvea.boot.system.cache.CacheService;
import cc.elvea.boot.system.cache.SimpleCacheKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Collection;

import static cc.elvea.boot.commons.constants.CacheConstants.MAX_BATCH_KEY_SIZE;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@NoRepositoryBean
public abstract class BaseCachingEntityService<T extends IdEntity, K extends Serializable, R extends BaseRepository<T, K>>
        extends BaseEntityService<T, K, R>
        implements CachingEntityService<T, K, R> {

    private final CacheKeyGenerator cacheKeyGenerator = new SimpleCacheKeyGenerator(this.getEntityClass().getSimpleName());

    private CacheService cacheService;

    @Override
    public T save(T entity) {
        T t = super.save(entity);
        deleteCache(t);
        return t;
    }

    @Override
    public T insert(T entity) {
        T t = super.insert(entity);
        setCache(t);
        return t;
    }

    @Override
    public T updateById(T entity) {
        T t = super.updateById(entity);
        deleteCache(t);
        return t;
    }

    @Override
    public void saveBatch(Collection<T> entityList, int batchSize) {
        if (CollectionUtils.isNotEmpty(entityList)) {
            super.saveBatch(entityList, batchSize);
            entityList.forEach(this::deleteCache);
        }
    }

    @Override
    public void delete(T entity) {
        super.delete(entity);
        this.deleteCache(entity);
    }

    @Override
    public void deleteById(K id) {
        this.delete(findById(id));
    }

    @Override
    public void deleteBatch(Collection<T> entityList, int batchSize) {
        if (CollectionUtils.isNotEmpty(entityList)) {
            super.deleteBatch(entityList);
            entityList.forEach(this::deleteCache);
        }
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        this.clearCache();
    }

    @Override
    public CacheService getCacheService() {
        return this.cacheService;
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public CacheKeyGenerator getCacheKeyGenerator() {
        return this.cacheKeyGenerator;
    }

    @Override
    public int getBatchSize() {
        return MAX_BATCH_KEY_SIZE;
    }

}
