package cc.elvea.boot.system.logging.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.logging.model.entity.UrlLogEntity;
import cc.elvea.boot.system.logging.repository.UrlLogRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UrlLogService extends EntityService<UrlLogEntity, Long, UrlLogRepository> {
}
