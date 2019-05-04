package com.github.houbb.opencc4j.core;

/**
 * 中文繁体转换接口
 * @author binbin.hou
 * @since 1.1.0
 */
public interface TraditionalZhConvert {

    /**
     * 转换为繁体
     * @param original 原始字符串
     * @return 繁体
     */
    String toTraditional(final String original);

}
