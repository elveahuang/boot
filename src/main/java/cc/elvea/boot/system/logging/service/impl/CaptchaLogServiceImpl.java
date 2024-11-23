package cc.elvea.boot.system.logging.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.logging.model.entity.CaptchaLogEntity;
import cc.elvea.boot.system.logging.repository.CaptchaLogRepository;
import cc.elvea.boot.system.logging.service.CaptchaLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@AllArgsConstructor
@Service
public class CaptchaLogServiceImpl extends BaseEntityService<CaptchaLogEntity, Long, CaptchaLogRepository> implements CaptchaLogService {
}
