package cc.elvea.boot.system.core.api.impl;

import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.core.api.UserSessionApi;
import cc.elvea.boot.system.core.model.dto.UserSessionDto;
import cc.elvea.boot.system.core.service.UserSessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author elvea
 * @since 24.1.0
 */
@Component
@AllArgsConstructor
public class UserSessionApiImpl implements UserSessionApi {

    private final UserSessionService userSessionService;

    @Override
    public Response<Boolean> saveUserSession(UserSessionDto dto) {
        this.userSessionService.saveUserSession(dto);
        return Response.success(Boolean.TRUE);
    }

}
