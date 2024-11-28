package cc.elvea.boot.commons.exception;

/**
 * @author elvea
 * @since 24.1.0
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable throwable) {
        super(throwable);
    }

    public SystemException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
