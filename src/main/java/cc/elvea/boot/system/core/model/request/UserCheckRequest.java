package cc.elvea.boot.system.core.model.request;

import cc.elvea.boot.commons.web.request.Request;
import lombok.*;

/**
 * @since elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserCheckRequest extends Request {
    private Long id;
    private String username;
    private String email;
    private String mobileCountryCode;
    private String mobileNumber;
}
