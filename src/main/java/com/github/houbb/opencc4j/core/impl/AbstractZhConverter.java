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
    protected StringBuffer stringBuffer;

    /**
     * 配置信息
     */
    protected Config config;

    @Override
    public ZhConverter setConfig(Config config) {
        this.config = config;
        return this;
    }

    @Override
    public ZhConverter setOriginal(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
        return this;
    }

    @Override
    public ZhConverter setOriginal(String string) {
        return this.setOriginal(new StringBuffer(string));
    }

    @Override
    public ZhConverter clear() {
        this.stringBuffer = null;
        return this;
    }

    @Override
    public String getResult() {
        return stringBuffer.toString();
    }
}
