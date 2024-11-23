package cc.elvea.boot.commons.constants;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface MappingConstants {

    /**
     * 请求路径前缀
     */
    String URL_PREFIX = "/";

    /**
     * 接口请求路径前缀
     */
    String API_URL_PREFIX = URL_PREFIX + "api";

    /**
     * 接口请求路径前缀
     * Version - 1
     */
    String API_V1_URL_PREFIX = API_URL_PREFIX + "/v1";

    /**
     * 接口请求路径前缀
     * Version - 2
     */
    String API_V2_URL_PREFIX = API_URL_PREFIX + "/v2";

    /**
     * 后台管理系统请求路径前缀
     * Version - 1
     */
    String API_V1_ADMIN_URL_PREFIX = API_V1_URL_PREFIX + "/admin";

}
