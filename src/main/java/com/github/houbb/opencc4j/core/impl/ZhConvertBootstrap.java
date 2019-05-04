package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.SimpleZhConvert;
import com.github.houbb.opencc4j.core.TraditionalZhConvert;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.CharSegment;
import com.github.houbb.opencc4j.util.CollectionUtil;
import com.github.houbb.opencc4j.util.StringUtil;

import java.util.List;

/**
 * 中文转换器引导类
 * 1. 可以指定分词类型（后期陆续添加其他特性）
 * 2. 支持 fluent 语法
 *
 * @author binbin.hou
 * @since 1.1.0
 */
public class ZhConvertBootstrap implements ZhConvert {

    /**
     * 分词实现
     * 1. 默认使用单词分词。
     */
    private Segment segment = new CharSegment();

    /**
     * 简体中文转换实现
     */
    private SimpleZhConvert simpleZhConvert = new DefaultSimpleZhConvert();

    /**
     * 繁体中文转换实现
     */
    private TraditionalZhConvert traditionalZhConvert = new DefaultTraditionalZhConvert();

    /**
     * 分词实现
     * @param segment 分词实现
     * @return 引导类本身
     */
    public ZhConvertBootstrap segment(final Segment segment) {
        this.segment = segment;
        return this;
    }

    /**
     * 指定简体中文转换类
     * @param simpleZhConvert 简体中文转换实现类
     * @return 引导类本身
     */
    public ZhConvertBootstrap simpleConvert(final SimpleZhConvert simpleZhConvert) {
        this.simpleZhConvert = simpleZhConvert;
        return this;
    }

    /**
     * 指定繁体中文转换类
     * @param traditionalZhConvert 繁体中文转换实现类
     * @return 引导类本身
     */
    public ZhConvertBootstrap traditionalConvert(final TraditionalZhConvert traditionalZhConvert) {
        this.traditionalZhConvert = traditionalZhConvert;
        return this;
    }

    @Override
    public String toSimple(String original) {
        //1. fast-fail
        if(StringUtil.isEmpty(original)) {
            return original;
        }
        List<String> stringList = segment.seg(original);
        if(CollectionUtil.isEmpty(stringList)) {
            return original;
        }

        //2. 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            String result = simpleZhConvert.toSimple(string);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toTraditional(String original) {
        //1. fast-fail
        if(StringUtil.isEmpty(original)) {
            return original;
        }
        List<String> stringList = segment.seg(original);
        if(CollectionUtil.isEmpty(stringList)) {
            return original;
        }

        //2. 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            String result = traditionalZhConvert.toTraditional(string);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

}
