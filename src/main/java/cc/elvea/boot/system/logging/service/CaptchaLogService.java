package cc.elvea.boot.system.logging.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.logging.model.entity.CaptchaLogEntity;
import cc.elvea.boot.system.logging.repository.CaptchaLogRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CaptchaLogService extends EntityService<CaptchaLogEntity, Long, CaptchaLogRepository> {
}
