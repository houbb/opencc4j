package com.github.houbb.opencc4j.util;

/**
 * 对象工具类
 * @author binbin.hou
 * @since 1.0.3
 */
public final class ObjectUtil {

    private ObjectUtil(){}

    /**
     * 是否为 null
     * @param object 对象
     * @return 是否
     */
    public static boolean isNull(final Object object) {
        return null == object;
    }

    /**
     * 是否为不 null
     * @param object 对象
     * @return 是否
     */
    public static boolean isNotNull(final Object object) {
        return !isNull(object);
    }
}
