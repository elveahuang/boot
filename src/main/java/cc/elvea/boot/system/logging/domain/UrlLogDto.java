package cc.elvea.boot.system.logging.domain;

import cc.elvea.boot.commons.annotations.DateTimeFormat;
import cc.elvea.boot.commons.annotations.JsonFormat;
import cc.elvea.boot.commons.constants.DateTimeConstants;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlLogDto implements Serializable {
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
