package cc.elvea.boot.commons.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class SimpleEntity extends AbstractEntity {

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

}
