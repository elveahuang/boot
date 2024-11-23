package cc.elvea.boot.system.core.service.impl;

import cc.elvea.boot.commons.service.BaseCachingEntityService;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.cache.CacheKeyGenerator;
import cc.elvea.boot.system.core.cache.ConfigCacheKeyGenerator;
import cc.elvea.boot.system.core.model.converter.ConfigConverter;
import cc.elvea.boot.system.core.model.entity.ConfigEntity;
import cc.elvea.boot.system.core.model.entity.ConfigEntity_;
import cc.elvea.boot.system.core.model.form.ConfigForm;
import cc.elvea.boot.system.core.repository.ConfigRepository;
import cc.elvea.boot.system.core.service.ConfigService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ConfigServiceImpl
        extends BaseCachingEntityService<ConfigEntity, Long, ConfigRepository>
        implements ConfigService {

    private final ConfigCacheKeyGenerator cacheKeyGenerator = new ConfigCacheKeyGenerator();

    private final ConfigConverter configConverter;

    @Override
    public ConfigEntity getConfig(String key) {
        return this.getCacheService().get(this.getCacheKeyGenerator().key(key), k -> {
            Specification<ConfigEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(builder.equal(root.get(ConfigEntity_.CONFIG_KEY), key));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public void saveConfig(ConfigForm form) {
        ConfigEntity entity;
        if (form.getId() != null && form.getId() > 0) {
            entity = this.findById(form.getId());
            ObjectUtils.copyNotNullProperties(form, entity);
        } else {
            entity = this.getConverter().formToEntity(form);
        }
        entity.setLastModifiedAt(this.getCurLocalDateTime());
        entity.setActive(form.getActive());
        this.save(entity);
    }

    @Override
    public void setCache(ConfigEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().set(this.getCacheKeyGenerator().byId(model.getId()), model);
            }
            if (StringUtils.isNotEmpty(model.getConfigKey())) {
                getCacheService().set(this.getCacheKeyGenerator().key(model.getConfigKey()), model);
            }
        }
    }

    @Override
    public void deleteCache(ConfigEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().delete(this.getCacheKeyGenerator().byId(model.getId()));
            }
            if (StringUtils.isNotEmpty(model.getConfigKey())) {
                getCacheService().delete(this.getCacheKeyGenerator().key(model.getConfigKey()));
            }
        }
    }

    @Override
    public CacheKeyGenerator getCacheKeyGenerator() {
        return this.cacheKeyGenerator;
    }

    protected ConfigConverter getConverter() {
        return configConverter;
    }

}
