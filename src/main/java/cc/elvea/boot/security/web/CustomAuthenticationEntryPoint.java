package cc.elvea.boot.security.web;

import cc.elvea.boot.commons.enums.ResponseCodeEnum;
import cc.elvea.boot.commons.utils.ServletUtils;
import cc.elvea.boot.commons.web.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.error("CustomAuthenticationEntryPoint.", e);
        if (e instanceof BadCredentialsException) {
            ServletUtils.renderJson(response, Response.fail(ResponseCodeEnum.USER__INVALID_USERNAME_OR_PASSWORD));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ServletUtils.renderJson(response, Response.fail(ResponseCodeEnum.UNAUTHORIZED));
        }
    }

}
