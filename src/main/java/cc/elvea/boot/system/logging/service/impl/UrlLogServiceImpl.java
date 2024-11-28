package cc.elvea.boot.system.logging.service.impl;

import cc.elvea.boot.commons.service.BaseEntityService;
import cc.elvea.boot.system.logging.model.entity.UrlLogEntity;
import cc.elvea.boot.system.logging.repository.UrlLogRepository;
import cc.elvea.boot.system.logging.service.UrlLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class UrlLogServiceImpl extends BaseEntityService<UrlLogEntity, Long, UrlLogRepository> implements UrlLogService {
}
