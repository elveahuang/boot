package cc.elvea.boot.system.storage.local;

import cc.elvea.boot.system.storage.AbstractStorageService;
import cc.elvea.boot.system.storage.domain.FileObject;
import cc.elvea.boot.system.storage.domain.FileParameter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
public class LocalStorageServiceImpl extends AbstractStorageService implements LocalStorageService {

    private final LocalStorageConfig config;

    public LocalStorageServiceImpl(LocalStorageConfig config) {
        this.config = config;
    }

    @Override
    public String getPath() {
        return this.config.getPath();
    }

    @Override
    public String getDomain() {
        return this.config.getDomain();
    }

    @Override
    public FileObject<?> getFile(String key, boolean withLocalFile) {
        return LocalFileObject.builder().key(key).build();
    }

    @Override
    public FileObject<?> uploadFile(InputStream is, FileParameter parameter) throws Exception {
        File file = new File(this.getPath(), parameter.getKey());
        FileUtils.forceMkdirParent(file);
        FileUtils.writeByteArrayToFile(file, IOUtils.toByteArray(is));
        log.info("LocalStorage putObject [{}].", file.getAbsolutePath());
        return LocalFileObject.builder().build();
    }

}
