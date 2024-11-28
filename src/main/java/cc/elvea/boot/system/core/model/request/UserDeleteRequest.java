package cc.elvea.boot.system.core.model.request;

import cc.elvea.boot.commons.web.request.Request;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserDeleteRequest extends Request {
    private Long[] ids;
}
