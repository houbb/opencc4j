package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.Segments;

import java.util.List;

/**
 * 中国台湾繁简体中文转换工具类
 *
 * @author bbhou
 * @author jackychu0830
 * @version 1.7.0
 */
public final class ZhTwConverterUtil {

    /**
     *  zh converter util
     * @since 1.7.0
     */
    private ZhTwConverterUtil(){}

    /**
     * 基于中国台湾的中文繁简体转换
     * @since 1.7.0
     */
    private static final ZhConvertBootstrap TW_INSTANCE = ZhConvertBootstrap
            .newInstance()
            .segment(Segments.twFastForward())
            .dataMap(DataMaps.taiwan());
    /**
     * 是否为简体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     *  @since 1.7.0
     */
    public static boolean isSimple(final String charOrPhrase) {
        return TW_INSTANCE.isSimple(charOrPhrase);
    }

    /**
     * 是否为繁体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     *  @since 1.7.0
     */
    public static boolean isTraditional(final String charOrPhrase) {
        return TW_INSTANCE.isTraditional(charOrPhrase);
    }

    /**
     * 简体字符列表
     * @param original 原始字符串
     * @return 简体字符列表
     *  @since 1.7.0
     */
    public static List<String> simpleList(final String original) {
        return TW_INSTANCE.simpleList(original);
    }

    /**
     * 繁体字符列表
     * @param original 原始字符串
     * @return 繁体字符列表
     *  @since 1.7.0
     */
    public static List<String> traditionalList(final String original) {
        return TW_INSTANCE.traditionalList(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.7.0
     */
    public static String toSimple(final String original) {
        return TW_INSTANCE.toSimple(original);
    }

    /**
     * 转换为繁体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.7.0
     */
    public static String toTraditional(final String original) {
        return TW_INSTANCE.toTraditional(original);
    }

    /**
     * 转换为繁体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.7.0
     */
    public static List<String> toTraditional(final char c) {
        return TW_INSTANCE.toTraditional(c);
    }

    /**
     * 转换为简体列表
     * @param c 繁体字符
     * @return 转换后的内容
     * @since 1.7.0
     */
    public static List<String> toSimple(final char c) {
        return TW_INSTANCE.toSimple(c);
    }

}
