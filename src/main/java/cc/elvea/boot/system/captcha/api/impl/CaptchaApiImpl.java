package cc.elvea.boot.system.captcha.api.impl;

import cc.elvea.boot.commons.enums.MessageTargetTypeEnum;
import cc.elvea.boot.commons.enums.MessageTemplateTypeEnum;
import cc.elvea.boot.system.captcha.Captcha;
import cc.elvea.boot.system.captcha.api.CaptchaApi;
import cc.elvea.boot.system.captcha.request.CaptchaCheckRequest;
import cc.elvea.boot.system.captcha.request.CaptchaRequest;
import cc.elvea.boot.system.captcha.service.CaptchaService;
import cc.elvea.boot.system.commons.constants.SystemMessageConstants;
import cc.elvea.boot.system.message.api.MessageApi;
import cc.elvea.boot.system.message.model.dto.CreateMessageDto;
import cc.elvea.boot.system.message.utils.MessageBuilder;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static cc.elvea.boot.commons.enums.CaptchaTypeEnum.MAIL;
import static cc.elvea.boot.commons.enums.CaptchaTypeEnum.SMS;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
public class CaptchaApiImpl implements CaptchaApi {

    private CaptchaService captchaService;

    private MessageApi messageApi;

    @Override
    public Captcha generate(CaptchaRequest request) throws Exception {
        Captcha captcha = this.captchaService.generate(request);
        if (SMS.equals(captcha.getType())) {
            Map<String, Object> params = Maps.newHashMap();
            params.put("code", captcha.getValue());

            CreateMessageDto message = MessageBuilder.builder()
                    .type(SystemMessageConstants.CAPTCHA_MESSAGE)
                    .templateType(MessageTemplateTypeEnum.SMS)
                    .targetType(MessageTargetTypeEnum.IMMEDIATE)
                    .sender(1L)
                    .recipient(request.getMobileCountryCode(), request.getMobileNumber())
                    .params(params)
                    .build();
            this.messageApi.createMessage(message);
        } else if (MAIL.equals(captcha.getType())) {
            Map<String, Object> params = Maps.newHashMap();
            params.put("code", captcha.getValue());
            CreateMessageDto message = MessageBuilder.builder()
                    .type(SystemMessageConstants.CAPTCHA_MESSAGE)
                    .templateType(MessageTemplateTypeEnum.MAIL)
                    .targetType(MessageTargetTypeEnum.IMMEDIATE)
                    .sender(1L)
                    .recipient(request.getEmail())
                    .params(params)
                    .build();
            this.messageApi.createMessage(message);
        }
        return captcha;
    }

    @Override
    public boolean check(CaptchaCheckRequest request) {
        return this.captchaService.check(request);
    }

    @Autowired
    public void setCaptchaService(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @Autowired
    public void setMessageApi(MessageApi messageApi) {
        this.messageApi = messageApi;
    }

}
