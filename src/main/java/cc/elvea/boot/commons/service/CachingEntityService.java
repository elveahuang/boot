package cc.elvea.boot.commons.service;

import cc.elvea.boot.commons.domain.IdEntity;
import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.commons.utils.CollectionUtils;
import cc.elvea.boot.system.cache.CacheKey;
import cc.elvea.boot.system.cache.CacheKeyGenerator;
import cc.elvea.boot.system.cache.CacheService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CachingEntityService<T extends IdEntity, K extends Serializable, R extends BaseRepository<T, K>>
        extends EntityService<T, K, R> {

    int getBatchSize();

    CacheService getCacheService();

    CacheKeyGenerator getCacheKeyGenerator();

    /**
     * 获取指定Key的缓存实体
     */
    default T findByCacheKey(CacheKey cacheKey) {
        return getCacheService().get(cacheKey);
    }

    /**
     * 获取指定Key的缓存实体
     */
    default T findByCacheKey(CacheKey cacheKey, Function<CacheKey, T> loader) {
        return getCacheService().get(cacheKey, loader);
    }

    /**
     * 获取指定Key的缓存实体
     */
    default List<T> findByCacheKey(Collection<CacheKey> keys) {
        return getCacheService().multiGetByCacheKey(keys);
    }

    /**
     * 基于缓存实现获取指定主键的实体
     *
     * @param id 主键
     * @return 实体
     */
    default T findCacheById(K id) {
        CacheKey cacheKey = getCacheKeyGenerator().key(id);
        return getCacheService().get(cacheKey, k -> this.findById(id));
    }

    /**
     * 基于缓存实现批量获取指定主键的实体
     *
     * @param ids 主键
     * @return 实体集合
     */
    default List<T> findCacheByIds(Collection<K> ids) {
        return findCacheByIds(ids, k -> findByIds(ids));
    }

    /**
     * 基于缓存实现批量获取指定主键的实体
     *
     * @param ids    主键
     * @param loader 缓存不存在时回调获取实体
     * @return 实体集合
     */
    default List<T> findCacheByIds(Collection<K> ids, Function<Collection<K>, Collection<T>> loader) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        List<CacheKey> cacheKeyList = ids.stream().map(getCacheKeyGenerator()::key).collect(Collectors.toList());
        List<List<CacheKey>> partitionKeyList = Lists.partition(cacheKeyList, getBatchSize());

        // 获取已缓存实体
        List<T> valueList = partitionKeyList.stream().map(this::findByCacheKey).flatMap(Collection::stream).toList();
        // 保存未缓存实体标识
        Set<K> keySet = Sets.newLinkedHashSet();
        // 保存未缓存实体标识
        List<K> keyList = Lists.newArrayList(ids);
        // 待返回实体
        List<T> entityList = new ArrayList<>();
        // 处理缓存标识，把未缓存实体标识排除出来，再从数据库里面获取
        if (CollectionUtils.isEmpty(valueList)) {
            keySet.addAll(keyList);
        } else {
            for (int i = 0; i < valueList.size(); i++) {
                T v = valueList.get(i);
                K k = keyList.get(i);
                if (v == null) {
                    keySet.add(k);
                } else {
                    entityList.add(v);
                }
            }
        }

        if (CollectionUtils.isNotEmpty(keySet)) {
            if (loader == null) {
                loader = this::findByIds;
            }
            Collection<T> missList = loader.apply(keySet);
            missList.forEach(this::setCache);
            entityList.addAll(missList);
        }
        return entityList;
    }

    /**
     * 刷新缓存
     */
    default void refreshCache() {
        this.findAll().forEach(this::setCache);
    }

    /**
     * 清理缓存
     */
    default void clearCache() {
        this.findAll().forEach(this::deleteCache);
    }

    /**
     * 删除实体缓存
     */
    default void deleteCache(T model) {
        if (hasId(model)) {
            getCacheService().delete(getCacheKeyGenerator().key(model.getId()));
        }
    }

    /**
     * 设置实体缓存
     */
    default void setCache(T model) {
        if (hasId(model)) {
            getCacheService().set(getCacheKeyGenerator().key(model.getId()), model);
        }
    }

}
