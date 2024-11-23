package cc.elvea.boot.system.core.repository;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTests extends BaseTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void baseTest() {
        Assertions.assertNotNull(userRepository);
        Assertions.assertNotNull(userRepository.findAll());
    }

}
