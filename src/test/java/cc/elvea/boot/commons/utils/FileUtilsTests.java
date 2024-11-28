package cc.elvea.boot.commons.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author elvea
 * @since 24.1.0
 */
public class FileUtilsTests {

    @Test
    void uploadTest() throws Exception {
        Resource resource = new ClassPathResource("logback-spring.xml");
        long size = FileUtils.getFileSize(resource.getFile());
        Assertions.assertTrue(size > 0);
        String extension = FileUtils.getExtension(resource.getFile());
        Assertions.assertEquals(extension, "xml");
        String contentType = FileUtils.getContentType(resource.getFile());
        Assertions.assertEquals(contentType, "application/xml");
    }

}
