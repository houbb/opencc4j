package com.github.houbb.opencc4j.util;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.CharSegment;
import com.github.houbb.opencc4j.support.segment.impl.HuaBanSegment;

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
     * 直接根据 char 分词的引导类
     * @since 1.3.0
     */
    private static final ZhConvertBootstrap CHAR_BS = ZhConvertBootstrap
            .newInstance(Instances.singleton(CharSegment.class));

    /**
     * 直接根据 huaban-jieba 分词的引导类
     * @since 1.3.0
     */
    private static final ZhConvertBootstrap HUABAN_BS = ZhConvertBootstrap
            .newInstance(Instances.singleton(HuaBanSegment.class));

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
        return HUABAN_BS.isSimple(charOrPhrase);
    }

    /**
     * 是否为繁体
     * @param charOrPhrase 单个字或者词组
     * @return 是否
     * @since 1.4.0
     */
    public static boolean isTraditional(final String charOrPhrase) {
        return HUABAN_BS.isTraditional(charOrPhrase);
    }

    /**
     * 简体字符列表
     * @param original 原始字符串
     * @return 简体字符列表
     * @since 1.4.0
     */
    public static List<String> simpleList(final String original) {
        return HUABAN_BS.simpleList(original);
    }

    /**
     * 繁体字符列表
     * @param original 原始字符串
     * @return 繁体字符列表
     * @since 1.4.0
     */
    public static List<String> traditionalList(final String original) {
        return HUABAN_BS.traditionalList(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toSimple(String original) {
        return convertToSimple(original);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.3.0
     */
    public static String toTraditional(String original) {
        return convertToTraditional(original);
    }

    /**
     * 转换为简体
     * 1. 默认使用花瓣分词
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.0.0
     * @see #toSimple(String) 使用这个代替
     */
    @Deprecated
    public static String convertToSimple(String original) {
        return convertToSimple(original, true);
    }

    /**
     * 转换为繁体
     * 1. 默认使用花瓣分词
     * @param original 原始内容
     * @return 转换后的内容
     * @since 1.0.0
     * @see #toTraditional(String) 使用这个代替
     */
    @Deprecated
    public static String convertToTraditional(String original){
        return convertToTraditional(original, true);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @param huabanSegment 是否花瓣分词
     * @return 转换后的内容
     * @since 1.0.0
     */
    @Deprecated
    public static String convertToSimple(String original, boolean huabanSegment) {
        final ZhConvertBootstrap zhConvertBootstrap = getConvertBs(huabanSegment);

        return zhConvertBootstrap.toSimple(original);
    }

    /**
     * 转换为繁体
     * @param original 原始内容
     * @param huabanSegment 是否花瓣分词
     * @return 转换后的内容
     * @since 1.0.0
     */
    @Deprecated
    public static String convertToTraditional(String original, boolean huabanSegment){
        final ZhConvertBootstrap zhConvertBootstrap = getConvertBs(huabanSegment);

        return zhConvertBootstrap.toTraditional(original);
    }

    /**
     * 获取转换引导类
     * @param huabanSegment 花瓣分词
     * @return 引导类
     * @since 1.3.0
     */
    private static ZhConvertBootstrap getConvertBs(final boolean huabanSegment) {
        if(huabanSegment) {
            return HUABAN_BS;
        }
        return CHAR_BS;
    }

}
