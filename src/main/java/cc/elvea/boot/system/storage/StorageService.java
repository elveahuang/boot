package cc.elvea.boot.system.storage;

import cc.elvea.boot.commons.utils.FileUtils;
import cc.elvea.boot.system.storage.domain.FileObject;
import cc.elvea.boot.system.storage.domain.FileParameter;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface StorageService {

    /**
     * 获取文件信息
     */
    default FileObject<?> getFile(String path) {
        return this.getFile(path, false);
    }

    /**
     * 获取文件信息
     */
    FileObject<?> getFile(String path, boolean withLocalTempFile);

    /**
     * 上传文件
     */
    default FileObject<?> uploadFile(MultipartFile file) throws Exception {
        FileParameter parameter = FileParameter.builder()
                .originalFilename(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .build();
        return this.uploadFile(file.getInputStream(), parameter);
    }

    /**
     * 上传文件
     */
    default FileObject<?> uploadFile(MultipartFile file, FileParameter parameter) throws Exception {
        return this.uploadFile(file.getInputStream(), parameter);
    }

    /**
     * 上传文件
     */
    default FileObject<?> uploadFile(File file) throws Exception {
        FileParameter parameter = FileParameter.builder()
                .originalFilename(file.getName())
                .contentType(FileUtils.getContentType(file))
                .size(FileUtils.getFileSize(file))
                .build();
        return this.uploadFile(file, parameter);
    }

    /**
     * 上传文件
     */
    default FileObject<?> uploadFile(File file, FileParameter parameter) throws Exception {
        try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
            return this.uploadFile(is, parameter);
        }
    }

    /**
     * 上传文件
     */
    FileObject<?> uploadFile(InputStream is, FileParameter parameter) throws Exception;

}
