package cc.elvea.boot.system.core.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;
import cc.elvea.boot.system.core.model.entity.UserSessionEntity;
import cc.elvea.boot.system.core.repository.UserSessionRepository;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UserSessionService extends EntityService<UserSessionEntity, Long, UserSessionRepository> {

    UserSessionEntity findBySessionId(String sessionId);

    void saveUserSession(UserSessionDto userSession);

}
