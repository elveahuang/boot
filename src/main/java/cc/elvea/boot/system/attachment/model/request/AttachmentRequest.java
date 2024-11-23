package cc.elvea.boot.system.attachment.model.request;

import cc.elvea.boot.commons.web.request.Request;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class AttachmentRequest extends Request {

    @Schema(title = "业务类型")
    private String bizType;

    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(title = "业务ID", defaultValue = "0")
    private Long bizId;

}
