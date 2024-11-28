package cc.elvea.boot.system.logging.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.logging.model.entity.OperationLogEntity;
import cc.elvea.boot.system.logging.repository.OperationLogRepository;
import cc.elvea.boot.system.logging.service.OperationLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class OperationLogServiceImpl extends BaseEntityService<OperationLogEntity, Long, OperationLogRepository> implements OperationLogService {
}
