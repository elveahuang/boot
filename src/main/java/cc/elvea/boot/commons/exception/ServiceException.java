package cc.elvea.boot.commons.exception;

import cc.elvea.boot.commons.enums.ResponseCodeEnum;
import cc.elvea.boot.commons.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Map;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResponseCodeEnum responseCode = ResponseCodeEnum.ERROR;

    public String code;

    public String message;

    public Map<String, Object> data;

    public Integer statusCode;

    public String description;

    public ServiceException() {
    }

    public ServiceException(ResponseCodeEnum responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        if (StringUtils.isEmpty(message)) {
            return super.getMessage();
        }
        return message;
    }

}
