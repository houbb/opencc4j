package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.support.tuple.impl.Pair;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.Segments;

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
     * @since 1.1.0
     */
    private Segment segment = Segments.defaults();

    /**
     * 数据集合实现
     * @since 1.5.2
     */
    private IDataMap dataMap = DataMaps.defaults();

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
     * （1）不是很建议使用，后期配置属性较多时，这样显然不够优雅。
     * @param segment 分词类
     * @return this
     * @since 1.2.0
     */
    @Deprecated
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
        return this.convert(original, segment, dataMap.tsPhrase(), dataMap.tsChar());
    }

    @Override
    public String toTraditional(String original) {
        return this.convert(original, segment, dataMap.stPhrase(), dataMap.stChar());
    }

    /**
     * 分词
     * @param original 原始字符串
     * @return 分词结果
     * @deprecated 0.1.5 分词不是本工具的核心能力，后续将移除（私有化）
     */
    @Override
    @Deprecated
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

        //1. 分词
        List<String> segments = StringUtil.toCharStringList(charOrPhrase);

        //2. 计算
        for(String word : segments) {
            // 经过多次实验发现，这样反而是最符合直觉的。
            // 因为部分人对于繁体比较敏感，但是对于繁简相同的字不敏感。
            if(dataMap.tChars().contains(word)) {
                return true;
            }
        }

        //3. 返回
        return false;
    }

    /**
     * 是否为单个繁体字得分
     *
     * 1.1 繁体包含 && 简体不包含  1
     * 1.2 繁体包含 && 简体包含   0
     * 1.3 繁体不包含 && 简体包含  -1
     * 1.4 繁体不包含 && 简体不包含 0
     *
     * @param word 单个字
     * @since 1.6.2
     * @return 繁体字的得分
     */
    @Deprecated
    private double traditionalWordScore(final String word) {
        return 0;
    }

    @Override
    public List<String> toSimple(char c) {
        return dataMap.tsChar().get(String.valueOf(c));
    }

    @Override
    public List<String> toTraditional(char c) {
        return dataMap.stChar().get(String.valueOf(c));
    }

    @Override
    public String toTwTraditional(String original) {
        return this.convert(original, segment, dataMap.sTwPhrase(), dataMap.sTwChar());
    }

    /**
     * 数据的 key 集合是否包含自定的单词或者词组
     * @param dataMap 数据集合
     * @param charOrPhrase 单个字或者词组
     * @return 是否包含
     * @since 1.2.0
     */
    @Deprecated
    private boolean dataKeyContains(final Map<String, List<String>> dataMap,
                                    final String charOrPhrase) {
        final Set<String> dataKeysSet = dataMap
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
                           final Map<String, List<String>> phraseData,
                           final Map<String, List<String>> charData) {
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
