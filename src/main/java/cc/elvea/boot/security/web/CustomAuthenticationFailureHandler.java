package cc.elvea.boot.security.web;

import cc.elvea.boot.commons.enums.ResponseCodeEnum;
import cc.elvea.boot.commons.exception.InvalidCaptchaException;
import cc.elvea.boot.commons.utils.ServletUtils;
import cc.elvea.boot.commons.web.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.http.converter.OAuth2ErrorHttpMessageConverter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final HttpMessageConverter<OAuth2Error> converter = new OAuth2ErrorHttpMessageConverter();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        log.info("CustomAuthenticationFailureHandler.onAuthenticationFailure...");

        if (e instanceof OAuth2AuthenticationException) {
            ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
            httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
            OAuth2Error error = ((OAuth2AuthenticationException) e).getError();
            this.converter.write(error, null, httpResponse);
        } else {
            if (e instanceof InvalidCaptchaException) {
                ServletUtils.renderJson(response, Response.fail(ResponseCodeEnum.INVALID_CAPTCHA));
            } else {
                ServletUtils.renderJson(response, Response.error(ResponseCodeEnum.ERROR));
            }
        }
    }

}
