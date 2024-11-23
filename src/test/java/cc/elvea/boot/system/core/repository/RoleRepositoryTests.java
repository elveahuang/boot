package cc.elvea.boot.system.core.repository;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleRepositoryTests extends BaseTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void baseTest() {
        Assertions.assertNotNull(roleRepository);
        Assertions.assertNotNull(roleRepository.findAll());
    }

}
