package cc.elvea.boot.system.core.model.request;

import cc.elvea.boot.commons.web.request.PageRequest;
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
public class UserSearchRequest extends PageRequest {
}
