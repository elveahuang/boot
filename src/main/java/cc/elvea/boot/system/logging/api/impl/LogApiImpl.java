package cc.elvea.boot.system.logging.api.impl;

import cc.elvea.boot.system.captcha.domain.CaptchaLogDto;
import cc.elvea.boot.system.logging.api.LogApi;
import cc.elvea.boot.system.logging.domain.OperationLogDto;
import cc.elvea.boot.system.logging.domain.UrlLogDto;
import cc.elvea.boot.system.logging.service.CaptchaLogService;
import cc.elvea.boot.system.logging.service.OperationLogService;
import cc.elvea.boot.system.logging.service.UrlLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class LogApiImpl implements LogApi {

    private final CaptchaLogService captchaLogService;

    private final OperationLogService operationLogService;

    private final UrlLogService urlLogService;

    @Override
    public void saveLogLog(UrlLogDto captchaLog) throws Exception {
    }

    @Override
    public void saveCaptchaLog(CaptchaLogDto captchaLog) throws Exception {
    }

    @Override
    public void saveOperationLog(OperationLogDto operationLog) throws Exception {
    }

}
