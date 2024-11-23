package cc.elvea.boot.system.captcha.service;

import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.provider.CaptchaProvider;
import cc.elvea.boot.system.captcha.request.CaptchaCheckRequest;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CaptchaService {

    Captcha generate(CaptchaRequest request) throws Exception;

    /**
     * 检查验证码
     */
    boolean check(CaptchaCheckRequest request);

    /**
     * 检查验证码，不管结果是否成功，检查后都将删除验证码
     */
    boolean validate(CaptchaCheckRequest request);

    CaptchaProvider getCaptchaProvider(CaptchaRequest request);

}
