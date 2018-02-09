package com.github.houbb.opencc4j.support.config;

import com.github.houbb.opencc4j.constant.AppConstant;

public class DefaultConfig implements Config {

    /**
     * 单词路径
     */
    protected String charPath;

    /**
     * 短语路径
     */
    protected String phrasePath;

    /**
     * 原始的编码
     * 默认：UTF-8
     */
    protected String originalCharset;

    /**
     * 目标的编码
     * 默认：UTF-8
     */
    protected String targetCharset;

    public DefaultConfig(String charPath, String phrasePath, String originalCharset, String targetCharset) {
        this.charPath = charPath;
        this.phrasePath = phrasePath;
        this.originalCharset = originalCharset;
        this.targetCharset = targetCharset;
    }

    public DefaultConfig(String charPath, String phrasePath) {
        this(charPath, phrasePath, AppConstant.DEFAULT_CHARSET,
                AppConstant.DEFAULT_CHARSET);
    }

    public DefaultConfig() {
    }

    @Override
    public String charPath() {
        return this.charPath;
    }

    @Override
    public String phrasePath() {
        return this.phrasePath;
    }

    @Override
    public String originalCharset() {
        return this.originalCharset;
    }

    @Override
    public String targetCharset() {
        return this.targetCharset;
    }
}
