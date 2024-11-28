package cc.elvea.boot.system.core.api;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static cc.elvea.boot.system.commons.constants.SystemConfigConstants.LOGIN_CAPTCHA_ENABLED;

public class ConfigApiTests extends BaseTests {

    @Autowired
    private ConfigApi configApi;

    @Test
    void baseTest() {
        Assertions.assertNotNull(configApi);
        boolean loginCaptchaEnabled = configApi.getBoolean(LOGIN_CAPTCHA_ENABLED);
        Assertions.assertFalse(loginCaptchaEnabled);
    }

}
