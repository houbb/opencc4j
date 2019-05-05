package com.github.houbb.opencc4j.core;

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
     */
    String toSimple(final String original);

    /**
     * 转换为繁体
     * @param original 原始字符串
     * @return 繁体
     */
    String toTraditional(final String original);

}
