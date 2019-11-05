package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;
import com.github.houbb.opencc4j.support.data.Data;
import com.github.houbb.opencc4j.support.data.impl.STCharData;
import com.github.houbb.opencc4j.support.data.impl.STPhraseData;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;
import com.github.houbb.opencc4j.support.data.impl.TSPhraseData;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.CharSegment;
import com.github.houbb.opencc4j.support.segment.impl.HuaBanSegment;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 中文转换器引导类
 * 1. 可以指定分词类型（后期陆续添加其他特性）
 * 2. 支持 fluent 语法
 * @author binbin.hou
 * @since 1.1.0
 */
public class ZhConvertBootstrap implements ZhConvert {

    /**
     * 指定分词实现
     * 1. 默认使用花瓣分词。
     * @since 1.1.0
     */
    private Segment segment = Instances.singleton(HuaBanSegment.class);

    /**
     * 构造器私有化
     * @since 1.2.0
     */
    private ZhConvertBootstrap(){}

    /**
     * 每次获取全新的对象
     * @return 引导类对象
     * @since 1.1.0
     */
    public static ZhConvertBootstrap newInstance() {
        return new ZhConvertBootstrap();
    }

    /**
     * 创建分词实例，并且制定分词实现
     * @param segment 分词类
     * @return this
     * @since 1.2.0
     */
    public static ZhConvertBootstrap newInstance(final Segment segment) {
        ZhConvertBootstrap bs = newInstance();
        bs.segment(segment);

        return bs;
    }

    /**
     * 分词实现
     * @param segment 分词实现，不可为空
     * @return 引导类本身
     */
    public ZhConvertBootstrap segment(final Segment segment) {
        ArgUtil.notNull(segment, "segment");
        this.segment = segment;
        return this;
    }

    @Override
    public String toSimple(String original) {
        return this.convert(original, segment,
                Instances.singleton(TSPhraseData.class).data().getDataMap(),
                Instances.singleton(TSCharData.class).data().getDataMap());
    }

    @Override
    public String toTraditional(String original) {
        return this.convert(original, segment,
                Instances.singleton(STPhraseData.class).data().getDataMap(),
                Instances.singleton(STCharData.class).data().getDataMap());
    }

    @Override
    public List<String> doSeg(String original) {
        if(StringUtil.isEmpty(original)) {
            return Guavas.newArrayList();
        }

        return this.segment.seg(original);
    }

    @Override
    public List<String> simpleList(String original) {
        List<String> simpleList = Guavas.newArrayList();

        List<String> segList = this.doSeg(original);
        for(String seg : segList) {
            if(isSimple(seg)) {
                simpleList.add(seg);
            }
        }
        return simpleList;
    }

    @Override
    public List<String> traditionalList(String original) {
        List<String> traditionalList = Guavas.newArrayList();

        List<String> segList = this.doSeg(original);
        for(String seg : segList) {
            if(isTraditional(seg)) {
                traditionalList.add(seg);
            }
        }
        return traditionalList;
    }

    @Override
    public boolean isSimple(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        // 不是繁体就认为是简体。
        return !isTraditional(charOrPhrase);
    }

    @Override
    public boolean isTraditional(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        final int length = charOrPhrase.length();
        //1. 是否为简体单个字
        if(length == 1) {
            return dataKeyContains(TSCharData.class, charOrPhrase);
        }

        //2. 如果超过1，则从词组中进行判断
        boolean isTraditionalPhrase = dataKeyContains(TSPhraseData.class, charOrPhrase);
        if(isTraditionalPhrase) {
            return true;
        }

        //3. 如果不是繁体的词组，则直接进行单个 char 的分词，如果每一个字都是繁体，则认为是繁体。
        List<String> segList = Instances.singleton(CharSegment.class).seg(charOrPhrase);
        for(String seg : segList) {
            if(!isTraditional(seg)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 数据的 key 集合是否包含自定的单词或者词组
     * @param dataClass 数据集合类
     * @param charOrPhrase 单个字或者词组
     * @return 是否包含
     * @since 1.2.0
     */
    private boolean dataKeyContains(final Class<? extends Data> dataClass,
                                    final String charOrPhrase) {
        final Set<String> dataKeysSet = Instances.singleton(dataClass)
                .data()
                .getDataMap()
                .keySet();

        return dataKeysSet.contains(charOrPhrase);
    }

    /**
     * 指定转换
     * @param original 原始字符串
     * @param segment 分词实现
     * @param charData 单个词数据
     * @param phraseData 词组数据
     * @return 转换后的结果
     * @since 1.1.0
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
        final UnitConvert unitConvert = Instances.singleton(DefaultUnitConvert.class);
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
