package cc.elvea.boot.system.logging.api;

import cc.elvea.boot.system.captcha.domain.CaptchaLogDto;
import cc.elvea.boot.system.logging.domain.OperationLogDto;
import cc.elvea.boot.system.logging.domain.UrlLogDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface LogApi {

    void saveLogLog(UrlLogDto captchaLog) throws Exception;

    void saveOperationLog(OperationLogDto operationLog) throws Exception;

    void saveCaptchaLog(CaptchaLogDto captchaLog) throws Exception;

}
