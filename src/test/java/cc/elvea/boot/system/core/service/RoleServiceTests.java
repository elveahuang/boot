package cc.elvea.boot.system.core.service;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.system.core.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceTests extends BaseTests {

    @Autowired
    private RoleService roleService;

    @Test
    void baseTest() {
        Assertions.assertNotNull(roleService);
        Assertions.assertNotNull(roleService.findAll());
    }

}
