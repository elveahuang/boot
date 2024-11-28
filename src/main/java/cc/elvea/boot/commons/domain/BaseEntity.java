package cc.elvea.boot.commons.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * @author elvea
 * @since 24.1.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity extends AbstractEntity {

    /**
     * 启用状态
     */
    private Boolean active;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * 创建人
     */
    @CreatedBy
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdBy;

    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    /**
     * 最后修改人
     */
    @LastModifiedBy
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lastModifiedBy;

    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;

    /**
     * 删除人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deletedBy;

}
