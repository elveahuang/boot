package cc.elvea.boot.system.attachment.service;

import cc.elvea.boot.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AttachmentTypeServiceTests extends BaseTests {

    @Autowired
    private AttachmentTypeService attachmentTypeService;

    @Test
    void contextTest() {
        Assertions.assertNotNull(attachmentTypeService);
    }

}
