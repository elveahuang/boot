package cc.elvea.boot.security.service;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceTests extends BaseTests {

    @Autowired
    private ClientService clientService;

    @Test
    void baseTest() {
        Assertions.assertNotNull(clientService);
        clientService.findClientByClientId("webapp");
    }

}
