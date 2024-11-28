package cc.elvea.boot.system.core.service;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.system.core.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTests extends BaseTests {

    @Autowired
    private UserService userService;

    @Test
    void baseTest() {
        Assertions.assertNotNull(userService);
        Assertions.assertNotNull(userService.findAll());
    }

}
