package cc.elvea.boot.commons.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.lang.Nullable;

import java.util.UUID;

/**
 * @author elvea
 * @since 24.1.0
 */
public abstract class StringUtils extends org.springframework.util.StringUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean isEmpty(@Nullable String str) {
        return !hasLength(str);
    }

    public static boolean isNotEmpty(@Nullable String str) {
        return !isEmpty(str);
    }


    public static String randomAlphabetic(int count) {
        return RandomStringUtils.secure().nextAlphabetic(count);
    }

    public static String randomNumeric(int count) {
        return RandomStringUtils.secure().nextNumeric(count);
    }

    /**
     * 用于将雪花算法生成的ID转成36进制，缩短长度，可以用于邀请码之类唯一标识，虽然还是有点长。
     */
    public static String toString(Long value, int radix) {
        return Long.toString(value, radix).toUpperCase();
    }

}
