package cc.elvea.boot.system.message.model.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
public class MessageSenderDto {
    private Long id;
    private String username;
    private String displayName;
    private String email;
    private String mobileCountryCode;
    private String mobileNumber;
}
