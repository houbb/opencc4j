package com.github.houbb.opencc4j.util;

import java.util.Collection;

/**
 * 集合工具类
 * @author binbin.hou
 * @date 2019/4/30
 * @since 1.0.3
 */
public final class CollectionUtil {

    private CollectionUtil(){}

    /**
     * 集合是否为空
     * @param collection 集合
     * @return 是否
     */
    public static boolean isEmpty(final Collection collection) {
        return null == collection || collection.isEmpty();
    }

}
