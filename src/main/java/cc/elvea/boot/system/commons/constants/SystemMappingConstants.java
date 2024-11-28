package cc.elvea.boot.system.commons.constants;

import static cc.elvea.boot.commons.constants.MappingConstants.API_V1_URL_PREFIX;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface SystemMappingConstants {

    // -----------------------------------------------------------------------------------------------------------------
    //  公共接口
    // -----------------------------------------------------------------------------------------------------------------

    String API_V1_INITIALIZE = API_V1_URL_PREFIX + "/initialize";
    String API_V1_TEST = API_V1_URL_PREFIX + "/test";

    // -----------------------------------------------------------------------------------------------------------------
    // 附件模块
    // -----------------------------------------------------------------------------------------------------------------

    String API_V1__ATTACHMENT__GET_ATTACHMENT_TYPE = API_V1_URL_PREFIX + "/attachment/type";
    String API_V1__ATTACHMENT__GET_ATTACHMENT = API_V1_URL_PREFIX + "/attachment";
    String API_V1__ATTACHMENT__UPLOAD_ATTACHMENT = API_V1_URL_PREFIX + "/attachment/upload";
    String API_V1__ATTACHMENT__UPLOAD_EDITOR_ATTACHMENT = API_V1_URL_PREFIX + "/attachment/editor/upload";

}
