package cc.elvea.boot.commons.exception;

/**
 * @author elvea
 * @since 24.1.0
 */
public class RateLimitException extends RuntimeException {

    public RateLimitException() {
    }

    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException(String message, Throwable cause) {
        super(message, cause);
    }

}
