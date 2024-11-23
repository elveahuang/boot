package cc.elvea.boot.system.captcha.store;

import cc.elvea.boot.system.captcha.Captcha;

import java.time.Duration;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface CaptchaStore {

    Captcha get(String key);

    void set(String key, Captcha value, Duration duration);

    void remove(String key);

}
