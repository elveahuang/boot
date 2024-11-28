package cc.elvea.boot.system.core.repository;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorityRepositoryTests extends BaseTests {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    void baseTest() {
        Assertions.assertNotNull(authorityRepository);
        Assertions.assertNotNull(authorityRepository.findAll());
    }

}
