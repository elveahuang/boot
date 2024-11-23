package cc.elvea.boot.commons.utils;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtilsTests extends BaseTests {

    @Test
    void contextLoads() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("test"));
    }

}
