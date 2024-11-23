package cc.elvea.boot.system.captcha.provider;

import cc.elvea.boot.commons.enums.CaptchaTypeEnum;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

/**
 * @author elvea
 * @since 24.1.0
 */
public class DefaultCodeCaptchaProvider implements CodeCaptchaProvider {

    @Override
    public Captcha generate(CaptchaRequest request) {
        int length = (request.getSize() <= 0) ? 4 : request.getSize();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(160, 24, length, 16);
        lineCaptcha.getImageBase64();
        return Captcha.builder().type(CaptchaTypeEnum.CODE)
                .key(StringUtils.uuid())
                .value(lineCaptcha.getCode())
                .image(lineCaptcha.getImageBase64Data())
                .build();
    }

}
