package cc.elvea.boot.system.core.model.request;

import cc.elvea.boot.commons.web.request.Request;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountDeleteRequest extends Request {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long[] ids;
}
