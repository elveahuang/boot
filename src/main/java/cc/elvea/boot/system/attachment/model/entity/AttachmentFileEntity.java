package cc.elvea.boot.system.attachment.model.entity;

import cc.elvea.boot.commons.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author elvea
 * @since 24.1.0
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_attachment_file")
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AttachmentFileEntity extends BaseEntity {
    /**
     * 附件类型
     */
    private String attachmentType;
    /**
     * 内容类型
     */
    private String contentType;
    /**
     * 存储类型
     */
    private String storageType;
    /**
     * 访问类型
     */
    private String accessType;
    /**
     * 原始文件名
     */
    private String originalFilename;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件标识
     */
    private String fileKey;
    /**
     * 文件链接
     */
    private String url;
    /**
     * 附加信息
     */
    private String extra;
    /**
     * 文件大小
     */
    private Long size;
}
