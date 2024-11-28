package cc.elvea.boot.system.captcha.api;

import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.request.CaptchaCheckRequest;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CaptchaApi {

    Captcha generate(CaptchaRequest request) throws Exception;

    boolean check(CaptchaCheckRequest request);

}
