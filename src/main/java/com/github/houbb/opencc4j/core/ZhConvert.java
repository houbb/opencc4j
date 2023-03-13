package com.github.houbb.opencc4j.core;

import java.util.List;

/**
 * <p> 中文转换接口 </p>
 *
 * <pre> Created: 2018/6/22 下午2:42  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.1.0
 * @since 1.1.0
 */
public interface ZhConvert {

    /**
     * 转换为简体
     * @param original 原始字符串
     * @return 简体
     * @since 1.1.0
     */
    String toSimple(final String original);

    /**
     * 转换为繁体
     * @param original 原始字符串
     * @return 繁体
     * @since 1.1.0
     */
    String toTraditional(final String original);

    /**
     * 获取分词后的字符串列表
     * （1）如果原始字符串为空，则返回空列表
     * @param original 原始字符串
     * @return 字符串列表
     * @since 1.2.0
     * @deprecated 1.5.0  分词不是本工具的核心，将在后续版本移除
     */
    @Deprecated
    List<String> doSeg(final String original);

    /**
     * 返回简体字列表
     * 说明：返回 {@link #doSeg(String)} 列表中符合 {@link #isSimple(String)} 的字符串列表
     * @param original 原始字符串列表
     * @return 包含的简体字符串列表
     * @since 1.2.0
     */
    List<String> simpleList(final String original);

    /**
     * 返回繁体字列表
     * 说明：返回 {@link #doSeg(String)} 列表中符合 {@link #isTraditional(String)} 的字符串列表
     * @param original 原始字符串列表
     * @return 包含的繁体字符的列表
     * @since 1.2.0
     */
    List<String> traditionalList(final String original);

    /**
     * 是否为简体中文字符
     * @param c 字符
     * @return 结果
     * @since 1.8.0
     */
    boolean isSimple(final char c);

    /**
     * 是否全部为简体
     * （1）原始字符串为空，直接返回 false
     * （2）每一个字符都是简体中文
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     * @since 1.2.0
     */
    boolean isSimple(final String charOrPhrase);

    /**
     * 是否包含简体
     * （1）原始字符串为空，直接返回 false
     * （2）任何一个字符都是简体中文
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     * @since 1.8.0
     */
    boolean containsSimple(final String charOrPhrase);

    /**
     * 是否为繁体中文字符
     * @param c 字符
     * @return 结果
     * @since 1.8.0
     */
    boolean isTraditional(final char c);

    /**
     * 是否全部为繁体
     * 1. 原始字符串为空，直接返回 false
     * 2. 每一个字符都是繁体
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     * @since 1.2.0
     */
    boolean isTraditional(final String charOrPhrase);

    /**
     * 是否包含繁体
     * 1. 原始字符串为空，直接返回 false
     * 2. 任何一个字符都是繁体
     * @param charOrPhrase 字符
     * @return 结果
     * @since 1.8.0
     */
    boolean containsTraditional(final String charOrPhrase);

    /**
     * 是否为中文字符
     * @param c 字符
     * @return 是否
     * @since 1.8.0
     */
    boolean isChinese(final char c);

    /**
     * 是否全部为中文
     * 1. 为空，则直接为 false
     * 2. 要求每一个 char 都是中文才满足
     *
     * @param charOrPhrase 字符或者词组
     * @return 结果
     * @since 1.8.0
     */
    boolean isChinese(final String charOrPhrase);

    /**
     * 是否包含中文
     *
     * 1. 为空，则直接为 false
     * 2. 任何一个 char 是中文即可满足
     * @param charOrPhrase 字符或者数组
     * @return 结果
     * @since 1.8.0
     */
    boolean containsChinese(final String charOrPhrase);

    /**
     * 返回单个汉字对应的简体汉字列表
     * @param c 汉字
     * @return 结果
     * @since 1.6.0
     */
    List<String> toSimple(final char c);

    /**
     * 返回单个汉字对应的繁体汉字列表
     * @param c 汉字
     * @return 结果
     * @since 1.6.0
     */
    List<String> toTraditional(final char c);

}
