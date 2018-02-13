package com.github.houbb.opencc4j.support.config;

import com.github.houbb.opencc4j.constant.AppConstant;

/**
 *  default config
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
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

    /**    
     *  default config    
     *    
     * @param charPath char path    
     * @param phrasePath phrase path    
     * @param originalCharset original charset    
     * @param targetCharset target charset    
     */    
    public DefaultConfig(String charPath, String phrasePath, String originalCharset, String targetCharset) {
        this.charPath = charPath;
        this.phrasePath = phrasePath;
        this.originalCharset = originalCharset;
        this.targetCharset = targetCharset;
    }

    /**    
     *  default config    
     *    
     * @param charPath char path    
     * @param phrasePath phrase path    
     */    
    public DefaultConfig(String charPath, String phrasePath) {
        this(charPath, phrasePath, AppConstant.DEFAULT_CHARSET,
                AppConstant.DEFAULT_CHARSET);
    }

    /**    
     *  default config    
     */    
    public DefaultConfig() {
        //This is just an empty constructor
    }

    /**    
     * char path    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String charPath() {
        return this.charPath;
    }

    /**    
     * phrase path    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String phrasePath() {
        return this.phrasePath;
    }

    /**    
     * original charset    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String originalCharset() {
        return this.originalCharset;
    }

    /**    
     * target charset    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String targetCharset() {
        return this.targetCharset;
    }
}
