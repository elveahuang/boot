package cc.elvea.boot.system.captcha.provider;

import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CaptchaProvider {

    Captcha generate(CaptchaRequest request) throws Exception;

}
