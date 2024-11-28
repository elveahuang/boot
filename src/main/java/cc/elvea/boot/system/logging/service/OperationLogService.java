package cc.elvea.boot.system.logging.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.logging.model.entity.OperationLogEntity;
import cc.elvea.boot.system.logging.repository.OperationLogRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface OperationLogService extends EntityService<OperationLogEntity, Long, OperationLogRepository> {
}
