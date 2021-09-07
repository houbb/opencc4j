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
     * 是否为简体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     * @since 1.4.0
     */
    public static boolean isSimple(final String charOrPhrase) {
        return isSimple(charOrPhrase, Segments.defaults());
    }

    /**
     * 是否为简体
     * @param charOrPhrase 单个字或者词组
     * @param segment 分词
     * @return 是否
     * @since 1.4.0
     */
    @Deprecated
    public static boolean isSimple(final String charOrPhrase,
                                   final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).isSimple(charOrPhrase);
    }

    /**
     * 是否为繁体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     * @since 1.4.0
     */
    public static boolean isTraditional(final String charOrPhrase) {
        return isTraditional(charOrPhrase, Segments.defaults());
    }

    /**
     * 是否为繁体
     * @param charOrPhrase 单个字或者词组
     * @param segment 分词
     * @return 是否
     * @since 1.5.0
     */
    @Deprecated
    public static boolean isTraditional(final String charOrPhrase,
                                        final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).isTraditional(charOrPhrase);
    }

    /**
     * 简体字符列表
     * @param original 原始字符串
     * @return 简体字符列表
     * @since 1.4.0
     */
    public static List<String> simpleList(final String original) {
        return simpleList(original, Segments.defaults());
    }

    /**
     * 简体字符列表
     * @param original 原始字符串
     * @param segment 分词策略
     * @return 简体字符列表
     * @since 1.5.0
     */
    @Deprecated
    public static List<String> simpleList(final String original,
                                          final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).simpleList(original);
    }

    /**
     * 繁体字符列表
     * @param original 原始字符串
     * @return 繁体字符列表
     * @since 1.4.0
     */
    public static List<String> traditionalList(final String original) {
        return traditionalList(original, Segments.defaults());
    }

    /**
     * 繁体字符列表
     * @param original 原始字符串
     * @param segment 分词
     * @return 繁体字符列表
     * @since 1.5.0
     */
    @Deprecated
    public static List<String> traditionalList(final String original,
                                               final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).traditionalList(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toSimple(final String original) {
        return toSimple(original, Segments.defaults());
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @param segment 分词实现
     * @return 转换后的内容
     * @since 1.5.0
     */
    @Deprecated
    public static String toSimple(final String original,
                                  final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).toSimple(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @param segment 分词策略
     * @return 转换后的内容
     * @since 1.5.0
     */
    public static String toTraditional(final String original,
                                       final Segment segment) {
        return ZhConvertBootstrap.newInstance().segment(segment).toTraditional(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toTraditional(final String original) {
        return toTraditional(original, Segments.defaults());
    }

    /**
     * 转换为繁体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.6.0
     */
    public static List<String> toTraditional(final char c) {
        return ZhConvertBootstrap.newInstance().toTraditional(c);
    }

    /**
     * 转换为简体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.6.0
     */
    public static List<String> toSimple(final char c) {
        return ZhConvertBootstrap.newInstance().toSimple(c);
    }

}
