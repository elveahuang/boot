package cc.elvea.boot.system.core.api;

import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface UserSessionApi {

    Response<Boolean> saveUserSession(UserSessionDto userSession) throws Exception;

}
