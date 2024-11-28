package cc.elvea.boot.system.commons.api.impl;

import cc.elvea.boot.system.commons.api.CoreApi;
import cc.elvea.boot.system.commons.model.vo.InitializeVo;
import cc.elvea.boot.system.core.api.ConfigApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static cc.elvea.boot.system.commons.constants.SystemConfigConstants.LOGIN_CAPTCHA_ENABLED;

/**
 * @author elvea
 * @since 24.1.0
 */
@Service
@AllArgsConstructor
public class CoreApiImpl implements CoreApi {

    private final ConfigApi configApi;

    /**
     * @see CoreApi#initialize()
     */
    @Override
    public InitializeVo initialize() {
        return InitializeVo.builder()
                .loginCaptchaEnabled(this.configApi.getBoolean(LOGIN_CAPTCHA_ENABLED))
                .build();
    }

}
