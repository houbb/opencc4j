package com.github.houbb.opencc4j.support.config;

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
