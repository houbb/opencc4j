package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;
import com.github.houbb.opencc4j.support.data.impl.STCharData;
import com.github.houbb.opencc4j.support.data.impl.STPhraseData;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;
import com.github.houbb.opencc4j.support.data.impl.TSPhraseData;
import com.github.houbb.opencc4j.support.instance.Instance;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.HuaBanSegment;
import com.github.houbb.opencc4j.util.CollectionUtil;
import com.github.houbb.opencc4j.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * 中文转换器引导类
 * 1. 可以指定分词类型（后期陆续添加其他特性）
 * 2. 支持 fluent 语法
 * 3. 暂时不开放自定义繁简体的转换实现，因为没有提供词组数据。后期繁简体转换接口可能会调整。
 * @author binbin.hou
 * @since 1.1.0
 */
public class ZhConvertBootstrap implements ZhConvert {

    /**
     * 指定分词实现
     * 1. 默认使用花瓣分词。
     */
    private Segment segment = InstanceFactory.getInstance()
            .singleton(HuaBanSegment.class);

    /**
     * 分词实现
     * @param segment 分词实现
     * @return 引导类本身
     */
    public ZhConvertBootstrap segment(final Segment segment) {
        this.segment = segment;
        return this;
    }

    @Override
    public String toSimple(String original) {
        final Instance instance = InstanceFactory.getInstance();
        return this.convert(original, segment,
                instance.singleton(TSPhraseData.class).data().getDataMap(),
                instance.singleton(TSCharData.class).data().getDataMap());
    }

    @Override
    public String toTraditional(String original) {
        final Instance instance = InstanceFactory.getInstance();
        return this.convert(original, segment,
                instance.singleton(STPhraseData.class).data().getDataMap(),
                instance.singleton(STCharData.class).data().getDataMap());
    }

    /**
     * 指定转换
     * @param original 原始字符串
     * @param segment 分词实现
     * @param charData 单个词数据
     * @param phraseData 词组数据
     * @return 转换后的结果
     */
    private String convert(final String original,
                           final Segment segment,
                           final Map<String, String> phraseData,
                           final Map<String, String> charData) {
        //1. fast-fail
        if(StringUtil.isEmpty(original)) {
            return original;
        }
        List<String> stringList = segment.seg(original);
        if(CollectionUtil.isEmpty(stringList)) {
            return original;
        }

        //2. 转换对象构建
        final UnitConvert unitConvert = InstanceFactory.getInstance().singleton(DefaultUnitConvert.class);
        final DefaultUnitConvertContext unitConvertContext = new DefaultUnitConvertContext();
        unitConvertContext.setPhraseData(phraseData);
        unitConvertContext.setCharData(charData);

        //3. 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            unitConvertContext.setUnit(string);
            String result = unitConvert.convert(unitConvertContext);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

}
