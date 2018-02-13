package com.github.houbb.opencc4j.support.config;

/**
 *  config
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public interface Config {

    /**
     * 单词路径
     * @return
     */
    String charPath();

    /**
     * 短语路径
     * @return
     */
    String phrasePath();

    /**
     * 原始的编码
     * 默认：UTF-8
     * @return
     */
    String originalCharset();

    /**
     * 目标的编码
     * 默认：UTF-8
     * @return
     */
    String targetCharset();

}
