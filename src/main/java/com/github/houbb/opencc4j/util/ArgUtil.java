package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;

/**
 * 参数工具类
 * @author binbin.hou
 * @since 1.1.0
 */
public final class ArgUtil {

    private ArgUtil(){}

    /**
     * 断言参数不可为 null
     * @param object 对象
     * @param paramName 参数名称
     */
    public static void notNull(final Object object, final String paramName) {
        if(ObjectUtil.isNull(object)) {
            throw new Opencc4jRuntimeException(paramName+" can't be null!");
        }
    }

}
