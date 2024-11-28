package cc.elvea.boot.system.attachment.model.request;

import cc.elvea.boot.commons.web.request.Request;
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
public class AttachmentTypeRequest extends Request {

    /**
     * 附件类型ID
     */
    @Schema(title = "附件类型ID")
    private String attachmentType;

}
