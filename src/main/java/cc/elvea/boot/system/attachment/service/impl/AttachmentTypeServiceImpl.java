package cc.elvea.boot.system.attachment.service.impl;

import cc.elvea.boot.commons.service.BaseCachingEntityService;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity_;
import cc.elvea.boot.system.attachment.repository.AttachmentTypeRepository;
import cc.elvea.boot.system.attachment.service.AttachmentTypeService;
import cc.elvea.boot.system.cache.CacheKeyGenerator;
import cc.elvea.boot.system.cache.SimpleCacheKeyGenerator;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cc.elvea.boot.system.commons.constants.SystemCacheConstants.ATTACHMENT_TYPE;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
public class AttachmentTypeServiceImpl
        extends BaseCachingEntityService<AttachmentTypeEntity, Long, AttachmentTypeRepository>
        implements AttachmentTypeService {

    private final CacheKeyGenerator cacheKeyGenerator = new SimpleCacheKeyGenerator(ATTACHMENT_TYPE);

    @Override
    public AttachmentTypeEntity findByCode(String code) {
        return this.getCacheService().get(this.getCacheKeyGenerator().key(code), k -> {
            Specification<AttachmentTypeEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(builder.equal(root.get(AttachmentTypeEntity_.CODE), code));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public void setCache(AttachmentTypeEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().set(this.getCacheKeyGenerator().byId(model.getId()), model);
            }
            if (StringUtils.isNotEmpty(model.getCode())) {
                getCacheService().set(this.getCacheKeyGenerator().key(model.getCode()), model);
            }
        }
    }

    @Override
    public void deleteCache(AttachmentTypeEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().delete(this.getCacheKeyGenerator().byId(model.getId()));
            }
            if (StringUtils.isNotEmpty(model.getCode())) {
                getCacheService().delete(this.getCacheKeyGenerator().key(model.getCode()));
            }
        }
    }

    @Override
    public CacheKeyGenerator getCacheKeyGenerator() {
        return this.cacheKeyGenerator;
    }

}
