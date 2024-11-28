package cc.elvea.boot.system.core.model.form;

import cc.elvea.boot.commons.annotations.DateTimeFormat;
import cc.elvea.boot.commons.annotations.JsonFormat;
import cc.elvea.boot.commons.constants.DateTimeConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
    private String username;
    private String password;
    private String email;
    private String displayName;
    private String sex;
    @JsonFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    @DateTimeFormat(pattern = DateTimeConstants.DEFAULT_DATE_TIME_PATTERN)
    private LocalDate birthday;
    private String description;

}
