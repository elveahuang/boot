package cc.elvea.boot.system.core.model.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class PositionSaveDto implements Serializable {
    private Long id;
    private Long parentId;
    private String code;
    private String title;
    private String label;
    private String description;
}
