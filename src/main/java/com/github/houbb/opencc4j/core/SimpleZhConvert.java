package com.github.houbb.opencc4j.core;

/**
 * 中文简体转换接口
 * @author binbin.hou
 * @since 1.1.0
 */
public interface SimpleZhConvert {

    /**
     * 转换为简体
     * @param original 原始字符串
     * @return 简体
     */
    String toSimple(final String original);

}
