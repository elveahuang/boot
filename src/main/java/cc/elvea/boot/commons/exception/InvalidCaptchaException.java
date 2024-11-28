package cc.elvea.boot.commons.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author elvea
 * @since 24.1.0
 */
public class InvalidCaptchaException extends AuthenticationException {

    public InvalidCaptchaException(String msg) {
        super(msg);
    }

    public InvalidCaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
