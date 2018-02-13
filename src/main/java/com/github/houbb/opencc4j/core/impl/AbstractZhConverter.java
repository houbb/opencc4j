package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.ZhConverter;
import com.github.houbb.opencc4j.support.config.Config;

/**
 * 1. 内容为空，直接返回
 * 2. 分词。逐个循环匹配。
 * 3. 优先匹配短语，如果没有则匹配单词。还没有则返回文字本身。
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public abstract class AbstractZhConverter implements ZhConverter {

    /**
     * StringBuffer 信息
     */
    protected StringBuilder stringBuilder;

    /**
     * 配置信息
     */
    protected Config config;

    /**    
     * set config    
     *    
     * @param config config    
     * @return com.github.houbb.opencc4j.core.ZhConverter    
     */    
    @Override
    public ZhConverter setConfig(Config config) {
        this.config = config;
        return this;
    }

    /**    
     * set original    
     *    
     * @param stringBuilder  string builder
     * @return com.github.houbb.opencc4j.core.ZhConverter    
     */    
    @Override
    public ZhConverter setOriginal(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        return this;
    }

    /**    
     * set original    
     *    
     * @param string string    
     * @return com.github.houbb.opencc4j.core.ZhConverter    
     */    
    @Override
    public ZhConverter setOriginal(String string) {
        StringBuilder stringBuilder = string == null ? null : new StringBuilder(string);
        return this.setOriginal(stringBuilder);
    }

    /**    
     * clear    
     *    
     * @return com.github.houbb.opencc4j.core.ZhConverter    
     */    
    @Override
    public ZhConverter clear() {
        this.stringBuilder = null;
        return this;
    }

    /**    
     * get result    
     *    
     * @return java.lang.String    
     */    
    @Override
    public String getResult() {
        if(null == stringBuilder) {
            return null;
        }
        return stringBuilder.toString();
    }
}
