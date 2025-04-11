package com.github.houbb.opencc4j.core;

import java.util.List;

/**
 * <p> 中文转换接口 </p>
 *
 * @author houbinbin
 * @since 1.10.0
 */
public interface ZhConvertCore {

    /**
     * 转换为简体
     * @param original 原始字符串
     * @param context 上下文
     * @return 简体
     */
    String toSimple(final String original, final ZhConvertCoreContext context);

    /**
     * 转换为繁体
     * @param original 原始字符串
     * @param context 上下文
     * @return 繁体
     * @since 1.1.0
     */
    String toTraditional(final String original, final ZhConvertCoreContext context);

    /**
     * 返回简体字列表
     * @param original 原始字符串列表
     * @param context 上下文
     * @return 包含的简体字符串列表
     * @since 1.2.0
     */
    List<String> simpleList(final String original, final ZhConvertCoreContext context);

    /**
     * 返回繁体字列表
     * @param original 原始字符串列表
     * @param context 上下文
     * @return 包含的繁体字符的列表
     * @since 1.2.0
     */
    List<String> traditionalList(final String original, final ZhConvertCoreContext context);

    /**
     * 是否为简体中文字符
     * @param c 字符
     * @param context 上下文
     * @return 结果
     */
    boolean isSimple(final char c, final ZhConvertCoreContext context);

    /**
     * 是否全部为简体
     * @param context 上下文
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     */
    boolean isSimple(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 是否包含简体
     * @param context 上下文
     * @param charOrPhrase 单个字或者词组
     * @return true: 是; false: 否
     */
    boolean containsSimple(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 是否为繁体中文字符
     * @param c 字符
     * @param context 上下文
     * @return 结果
     */
    boolean isTraditional(final char c, final ZhConvertCoreContext context);

    /**
     * 是否全部为繁体
     * 1. 原始字符串为空，直接返回 false
     * 2. 每一个字符都是繁体
     * @param charOrPhrase 单个字或者词组
     * @param context 上下文
     * @return true: 是; false: 否
     */
    boolean isTraditional(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 是否包含繁体
     * 1. 原始字符串为空，直接返回 false
     * 2. 任何一个字符都是繁体
     * @param charOrPhrase 字符
     * @param context 上下文
     * @return 结果
     */
    boolean containsTraditional(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 是否为中文字符
     * @param c 字符
     * @param context 上下文
     * @return 是否
     */
    boolean isChinese(final char c, final ZhConvertCoreContext context);

    /**
     * 是否全部为中文
     * 1. 为空，则直接为 false
     * 2. 要求每一个 char 都是中文才满足
     *
     * @param charOrPhrase 字符或者词组
     * @param context 上下文
     * @return 结果
     */
    boolean isChinese(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 是否包含中文
     *
     * 1. 为空，则直接为 false
     * 2. 任何一个 char 是中文即可满足
     * @param charOrPhrase 字符或者数组
     * @param context 上下文
     * @return 结果
     */
    boolean containsChinese(final String charOrPhrase, final ZhConvertCoreContext context);

    /**
     * 返回单个汉字对应的简体汉字列表
     * @param c 汉字
     * @param context 上下文
     * @return 结果
     */
    List<String> toSimple(final char c, final ZhConvertCoreContext context);

    /**
     * 返回单个汉字对应的繁体汉字列表
     * @param c 汉字
     * @param context 上下文
     * @return 结果
     */
    List<String> toTraditional(final char c, final ZhConvertCoreContext context);

}
