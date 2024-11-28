package cc.elvea.boot.system.captcha.provider;

import cc.elvea.boot.commons.enums.CaptchaTypeEnum;
import cc.elvea.boot.commons.utils.StringUtils;
import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@AllArgsConstructor
public class DefaultSmsCaptchaProvider implements SmsCaptchaProvider {

    @Override
    public Captcha generate(CaptchaRequest request) throws Exception {
        int length = (request.getSize() <= 0) ? 6 : request.getSize();
        String number = StringUtils.randomNumeric(length);
        return Captcha.builder()
                .type(CaptchaTypeEnum.SMS)
                .mobileCountryCode(request.getMobileCountryCode())
                .mobileNumber(request.getMobileNumber())
                .key(StringUtils.uuid())
                .value(number).build();
    }

}
