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
@Table(name = "sys_attachment_relation")
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class AttachmentRelationEntity extends BaseEntity {
    /**
     * 目标业务类型
     */
    private String targetType;
    /**
     * 目标业务ID
     */
    private Long targetId;
    /**
     * 文件ID
     */
    private Long attachmentId;
}
