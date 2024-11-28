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
@Table(name = "sys_attachment_type")
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AttachmentTypeEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 标题
     */
    private String title;
    /**
     * 标签
     */
    private String label;
    /**
     * 来源
     */
    private Integer source;
    /**
     * 是否支持多个附件上传
     */
    private Boolean multipleInd;
    /**
     * 描述
     */
    private String description;
    /**
     * 文件后缀
     */
    private String ext;
    /**
     * 文件类型集合 image/png、image/jpeg、video/mp4
     */
    private String fileTypes;
}
