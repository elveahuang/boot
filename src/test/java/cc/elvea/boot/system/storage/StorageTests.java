package cc.elvea.boot.system.storage;

import cc.elvea.boot.BaseTests;
import cc.elvea.boot.commons.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class StorageTests extends BaseTests {

    @Autowired
    private StorageManager storageManager;

    @Test
    void baseTest() {
        Assertions.assertNotNull(storageManager);
    }

    @Test
    void uploadTest() throws Exception {
        Resource resource = new ClassPathResource("logback-spring.xml");
        long size = FileUtils.getFileSize(resource.getFile());
        Assertions.assertTrue(size > 0);
        storageManager.getStorageService().uploadFile(resource.getFile());
    }

}
