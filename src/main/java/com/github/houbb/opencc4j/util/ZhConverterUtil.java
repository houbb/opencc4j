package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.Segments;

import java.util.List;

/**
 * 中文转换工具类
 * 1. 编码问题本工具类，默认支持的为 UTF-8 格式的字符串。如果格式不统一，自行处理
 * 2. 每次都 new 一个对象保证线程安全性
 * 3. 建议使用 {@link ZhConvertBootstrap} 来代替当前工具类。
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public final class ZhConverterUtil {

    /**
     *  zh converter util
     * @since 1.0.0
     */
    private ZhConverterUtil(){}

    /**
     * 默认引导类
     * @since 1.8.0
     */
    private static final ZhConvertBootstrap DEFAULT_BOOTSTRAP = ZhConvertBootstrap.newInstance();

    /**
     * 是否为中文字符
     * @param c 字符
     * @return 是否
     * @since 1.8.0
     */
    public static boolean isChinese(final char c) {
        return DEFAULT_BOOTSTRAP.isChinese(c);
    }

    /**
     * 是否全部为中文
     * 1. 为空，则直接为 false
     * 2. 要求每一个 char 都是中文才满足
     *
     * @param charOrPhrase 字符或者词组
     * @return 结果
     * @since 1.8.0
     */
    public static boolean isChinese(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.isChinese(charOrPhrase);
    }

    /**
     * 是否包含中文
     *
     * 1. 为空，则直接为 false
     * 2. 任何一个 char 是中文即可满足
     * @param charOrPhrase 字符或者数组
     * @return 结果
     * @since 1.8.0
     */
    public static boolean containsChinese(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.containsChinese(charOrPhrase);
    }

    /**
     * 是否为简体中文字符
     * @param c 字符
     * @return 是否
     * @since 1.8.0
     */
    public static boolean isSimple(final char c) {
        return DEFAULT_BOOTSTRAP.isSimple(c);
    }

    /**
     * 是否全部为简体中文
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     * @since 1.4.0
     */
    public static boolean isSimple(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.isSimple(charOrPhrase);
    }

    /**
     * 是否包含简体中文
     * （1）原始字符串为空，直接返回 false
     * （2）任何一个字符都是简体中文
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     * @since 1.8.0
     */
    public static boolean containsSimple(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.containsSimple(charOrPhrase);
    }

    /**
     * 是否为繁体中文字符
     * @param c 字符
     * @return 结果
     * @since 1.8.0
     */
    public static boolean isTraditional(final char c) {
        return DEFAULT_BOOTSTRAP.isTraditional(c);
    }

    /**
     * 是否为繁体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     * @since 1.4.0
     */
    public static boolean isTraditional(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.isTraditional(charOrPhrase);
    }

    /**
     * 是否包含繁体
     * 1. 原始字符串为空，直接返回 false
     * 2. 任何一个字符都是繁体
     * @param charOrPhrase 字符
     * @return 结果
     * @since 1.8.0
     */
    public static boolean containsTraditional(final String charOrPhrase) {
        return DEFAULT_BOOTSTRAP.containsTraditional(charOrPhrase);
    }

    /**
     * 包含的简体字符列表
     * @param original 原始字符串
     * @return 简体字符列表
     * @since 1.4.0
     */
    public static List<String> simpleList(final String original) {
        return DEFAULT_BOOTSTRAP.simpleList(original);
    }

    /**
     * 包含的繁体字符列表
     * @param original 原始字符串
     * @return 繁体字符列表
     * @since 1.4.0
     */
    public static List<String> traditionalList(final String original) {
        return DEFAULT_BOOTSTRAP.traditionalList(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toSimple(final String original) {
        return DEFAULT_BOOTSTRAP.toSimple(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toTraditional(final String original) {
        return DEFAULT_BOOTSTRAP.toTraditional(original);
    }

    /**
     * 转换为繁体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.6.0
     */
    public static List<String> toTraditional(final char c) {
        return DEFAULT_BOOTSTRAP.toTraditional(c);
    }

    /**
     * 转换为简体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.6.0
     */
    public static List<String> toSimple(final char c) {
        return DEFAULT_BOOTSTRAP.toSimple(c);
    }

}
