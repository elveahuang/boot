package cc.elvea.boot.configuration.properties;

import cc.elvea.boot.commons.constants.DateTimeConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author elvea
 * @since 24.1.0
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(SequenceProperties.PREFIX)
public class SequenceProperties {

    public static final String PREFIX = "app.sequence";

    private long epoch = DateTimeConstants.EPOCH;

    private long workerId = 1;

    private long dataCenterId = 1;

}
