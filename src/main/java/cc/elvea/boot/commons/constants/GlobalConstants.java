package cc.elvea.boot.commons.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface GlobalConstants {


    /**
     * 全局版本号
     */
    String VERSION = "24.1.0";

    /**
     * 全局默认编码
     */
    Charset UTF8 = StandardCharsets.UTF_8;

    /**
     * 全局默认编码
     */
    String ENCODING = "UTF-8";

    int DEFAULT_BATCH_SIZE = 1000;

    /**
     * 默认缓存周期为2个小时
     */
    Duration DEFAULT_CACHE_DURATION = Duration.ofHours(2);

    /**
     * 缓存批处理记录数
     */
    int MAX_BATCH_CACHE_KEY_SIZE = 20;

    /**
     * 默认分隔符
     */
    String DELIMITER = "~|~";

    /**
     * 默认分隔符
     */
    String STR_DELIMITER = ",";

    /**
     * 默认分隔符
     */
    String DOT = ".";

    /**
     * 默认的邮件服务端口
     */
    int DEFAULT_SMTP_PORT = 25;

    /**
     * 默认的邮件服务端口
     */
    int DEFAULT_SMTP_SSL_PORT = 465;

}
