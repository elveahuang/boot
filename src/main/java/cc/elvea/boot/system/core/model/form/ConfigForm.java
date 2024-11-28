package cc.elvea.boot.system.core.model.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigForm implements Serializable {
    /**
     * ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
    /**
     * 参数名
     */
    private String configKey;
    /**
     * 参数值
     */
    private String configValue;
    /**
     * 文本类型
     */
    private Integer configType;
    /**
     * 分组
     */
    private String configGroup;
    /**
     * 默认值
     */
    private String defaultValue;
    /**
     * 是否启用
     */
    private Boolean active;
    /**
     * 备注
     */
    private String description;
    /**
     * 帮助信息
     */
    private String help;
    /**
     * 数据来源
     */
    private Integer source;
}
