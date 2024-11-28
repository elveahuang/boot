package cc.elvea.boot.system.captcha.service;

import cc.elvea.boot.commons.enums.CaptchaTypeEnum;
import cc.elvea.boot.commons.utils.ObjectUtils;
import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.provider.CaptchaProvider;
import cc.elvea.boot.system.captcha.provider.CodeCaptchaProvider;
import cc.elvea.boot.system.captcha.provider.MailCaptchaProvider;
import cc.elvea.boot.system.captcha.provider.SmsCaptchaProvider;
import cc.elvea.boot.system.captcha.request.CaptchaCheckRequest;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;
import cc.elvea.boot.system.captcha.store.CaptchaStore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class DefaultCaptchaService implements CaptchaService {

    private MailCaptchaProvider mailCaptchaProvider;

    private SmsCaptchaProvider smsCaptchaProvider;

    private CodeCaptchaProvider codeCaptchaProvider;

    private CaptchaStore captchaStore;

    @Override
    public Captcha generate(CaptchaRequest request) throws Exception {
        Captcha captcha = getCaptchaProvider(request).generate(request);
        captchaStore.set(captcha.getKey(), captcha, request.getDuration());
        return captcha;
    }

    @Override
    public boolean check(CaptchaCheckRequest request) {
        Captcha captcha = captchaStore.get(request.getKey());

        boolean result = false;
        if (CaptchaTypeEnum.MAIL.equals(request.getType())) {
            result = (!ObjectUtils.isEmpty(captcha)
                    && captcha.getEmail().equalsIgnoreCase(request.getEmail())
                    && captcha.getValue().equalsIgnoreCase(request.getValue()));
        } else if (CaptchaTypeEnum.SMS.equals(request.getType())) {
            result = (!ObjectUtils.isEmpty(captcha)
                    && captcha.getMobileNumber().equalsIgnoreCase(request.getMobileNumber())
                    && captcha.getValue().equalsIgnoreCase(request.getValue()));
        } else if (CaptchaTypeEnum.CODE.equals(request.getType())) {
            result = (!ObjectUtils.isEmpty(captcha) && captcha.getValue().equalsIgnoreCase(request.getValue()));
        }
        return result;
    }

    @Override
    public boolean validate(CaptchaCheckRequest request) {
        boolean result = check(request);
        captchaStore.remove(request.getKey());
        return result;
    }

    @Override
    public CaptchaProvider getCaptchaProvider(CaptchaRequest request) {
        if (CaptchaTypeEnum.SMS.equals(request.getType())) {
            return this.smsCaptchaProvider;
        } else if (CaptchaTypeEnum.MAIL.equals(request.getType())) {
            return this.mailCaptchaProvider;
        } else if (CaptchaTypeEnum.CODE.equals(request.getType())) {
            return this.codeCaptchaProvider;
        }
        return this.codeCaptchaProvider;
    }

}
