package com.github.houbb.opencc4j.util;

/**
 * 字符串工具类
 * 1. 为了移除外部依赖。
 * @author binbin.hou
 * @date 2019/4/30
 * @since 1.0.3
 */
public final class StringUtil {

    private StringUtil(){}

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 空格
     */
    public static final String BLANK = " ";

    /**
     * 是否为空
     * @param string 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String string) {
        return null == string || EMPTY.equals(string);
    }

    /**
     * 是否不为空
     * @param string 字符串
     * @return 是否为空
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * 按照任意空格拆分
     * @param string 字符串
     * @return 拆分后的数组
     */
    public static String[] splitByAnyBlank(String string) {
        if (isEmpty(string)) {
            return new String[0];
        } else {
            String pattern = "\\s+";
            return string.split(pattern);
        }
    }

}
