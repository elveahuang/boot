package cc.elvea.boot.system.attachment.model.request;

import cc.elvea.boot.commons.enums.StorageTypeEnum;
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
public class AttachmentUploadRequest extends Request {

    /**
     * 附件类型ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long typeId;

    /**
     * 附件类型
     */
    private String attachmentType;

    /**
     * 附件类型
     */
    private String contentType;

    /**
     * 是否裁剪
     */
    @Builder.Default
    private Boolean crop = false;

    /**
     * 裁剪X坐标
     */
    @Builder.Default
    private Integer x = 0;

    /**
     * 裁剪Y坐标
     */
    @Builder.Default
    private Integer y = 0;

    /**
     * 裁剪宽度
     */
    @Builder.Default
    private Integer width = 0;

    /**
     * 裁剪高度
     */
    @Builder.Default
    private Integer height = 0;

    /**
     * 原始文件名
     */
    private String originalFilename;

    /**
     * 原始文件名
     */
    private long fileSize;

    /**
     * 存储引擎类型
     */
    private StorageTypeEnum storageType;

}
