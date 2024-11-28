package cc.elvea.boot.commons.utils;

import cc.elvea.boot.commons.constants.DateTimeConstants;
import cc.elvea.boot.commons.constants.GlobalConstants;
import cc.elvea.boot.system.storage.domain.FileParameter;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
public abstract class StorageUtils {

    public static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    /**
     * 生成文件标识
     */
    public static String generateKey(String filename, String path) {
        String key = "";
        if (StringUtils.isEmpty(path) || !path.trim().startsWith("/")) {
            key += "/";
        }
        key += path;
        if (!key.trim().endsWith("/")) {
            key += "/";
        }
        key += filename;
        return key;
    }

    /**
     * 根据UUID去除下划线生成唯一文件名
     */
    public static String generateFilename(String filename) {
        return new StringJoiner(GlobalConstants.DOT)
                .add(StringUtils.simpleUuid())
                .add(FilenameUtils.getExtension(filename))
                .toString();
    }

    /**
     * 根据当前日期生成文件路径
     */
    public static String generateDatePath() {
        return DateTimeUtils.format(LocalDate.now(), DateTimeConstants.DEFAULT_SIMPLE_DATE_PATTERN);
    }

    /**
     * 生成路径
     */
    public static String generatePath(String... paths) {
        return generatePath(Arrays.asList(paths));
    }

    /**
     * 生成路径
     */
    public static String generatePath(List<String> paths) {
        return org.apache.commons.lang3.StringUtils.join(paths, SEPARATOR);
    }

    /**
     * 生成路径
     */
    public static String generatePath(FileParameter parameter) {
        String path = parameter.getPath();
        if (StringUtils.isEmpty(path)) {
            path = DateTimeUtils.format(LocalDateTime.now(), DateTimeConstants.Pattern.SIMPLE_DATE);
        }
        return path;
    }

    /**
     * 生成文件标识
     */
    public static String generateKey(FileParameter parameter, String name, String path) {
        String key = parameter.getKey();
        if (StringUtils.isEmpty(key)) {
            return path + "/" + name;
        }
        return key;
    }

    public static String generateFileKey(FileParameter parameter) {
        String suffix = FilenameUtils.getExtension(parameter.getOriginalFilename());
        String uuid = IdUtil.simpleUUID();
        String path = DateTimeUtils.format(LocalDateTime.now(), DateTimeConstants.Pattern.SIMPLE_DATE);
        return path + "/" + uuid + "." + suffix;
    }

    public static String generateExtFilename(String ext) {
        return StringUtils.uuid() + "." + ext;
    }

    /**
     * 新建本地临时文件夹
     */
    public static File newTempFolder() {
        File tmpFile = new File(FileUtils.getTempDirectoryPath(), StringUtils.uuid());
        if (tmpFile.exists()) {
            try {
                FileUtils.forceDelete(tmpFile);
            } catch (IOException e) {
                log.error("file already exists, but delete failed!", e);
            }
        }
        if (tmpFile.mkdirs()) {
            return tmpFile;
        }
        return null;
    }

    /**
     * 新建本地临时文件
     */
    public static File newTempFile(String filename) throws Exception {
        File tmpFile = new File(FileUtils.getTempDirectoryPath(), filename);
        // 强制建立目录，避免目录不存在报错
        FileUtils.forceMkdirParent(tmpFile);
        // 临时文件如果已经存在，强制删除，重新创建文件
        if (tmpFile.exists()) {
            try {
                FileUtils.forceDelete(tmpFile);
            } catch (IOException e) {
                log.error("Fail to create temp file [{}].", filename, e);
            }
        }
        if (tmpFile.createNewFile()) {
            log.info("create new file {}.", tmpFile.getAbsolutePath());
        }
        return tmpFile;
    }

}
