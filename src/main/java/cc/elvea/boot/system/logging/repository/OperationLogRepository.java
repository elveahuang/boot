package cc.elvea.boot.system.logging.repository;

import cc.elvea.boot.commons.repository.BaseRepository;
import cc.elvea.boot.system.logging.model.entity.OperationLogEntity;
import org.springframework.stereotype.Repository;

/**
 * @author elvea
 * @since 24.1.0
 */
@Repository
public interface OperationLogRepository extends BaseRepository<OperationLogEntity, Long> {
}