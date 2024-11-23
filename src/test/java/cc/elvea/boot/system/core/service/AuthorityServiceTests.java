package cc.elvea.boot.system.core.service;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.system.core.service.AuthorityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorityServiceTests extends BaseTests {

    @Autowired
    private AuthorityService authorityService;

    @Test
    void baseTest() {
        Assertions.assertNotNull(authorityService);
        Assertions.assertNotNull(authorityService.findAll());
    }

}
