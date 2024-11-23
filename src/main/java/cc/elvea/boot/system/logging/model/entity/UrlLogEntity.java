package cc.elvea.boot.system.logging.model.entity;

import cc.elvea.boot.commons.annotations.DateTimeFormat;
import cc.elvea.boot.commons.annotations.JsonFormat;
import cc.elvea.boot.commons.constants.DateTimeConstants;
import cc.elvea.boot.commons.domain.SimpleEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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
@Table(name = "sys_url_log")
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class UrlLogEntity extends SimpleEntity {
    /**
     * 路径
     */
    private String path;
    /**
     * 日志的开始时间
     */
    @JsonFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    @DateTimeFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    private LocalDateTime startTime;
    /**
     * 日志的开始时间
     */
    @JsonFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    @DateTimeFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    private LocalDateTime endTime;
    /**
     * 执行时长
     */
    private Long execTime;
}
