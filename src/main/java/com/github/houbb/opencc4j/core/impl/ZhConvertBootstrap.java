package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.CharUtil;
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
import com.github.houbb.opencc4j.util.InnerCharUtils;

import java.util.List;
import java.util.Map;

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

    /**
     * 设置数据集合，允许用户自定义
     *
     * @param dataMap 数据集合
     * @return this
     * @since 1.7.0
     */
    public ZhConvertBootstrap dataMap(IDataMap dataMap) {
        this.dataMap = dataMap;
        return this;
    }

    /**
     * 转字符串列表
     * @param original 原始文本
     * @return 正确的切分字符结果
     * @since 1.9.1
     */
    private List<String> toCharList(String original) {
        return InnerCharUtils.toCharList(original);
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
    public boolean isSimple(char c) {
        String sc = String.valueOf(c);
        return isSimpleForSingle(sc);
    }

    private boolean isSimpleForSingle(String c) {
        if(!isChinese(c)) {
            return false;
        }

        // 中文简体字符集中包含
        if(dataMap.sChars().contains(c)) {
            return true;
        }

        // 中文除去繁体的，认为是简体
        return !isTraditional(c);
    }

    @Override
    public boolean isSimple(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        //TODO: 这里可以抽象为 allMatch 和 anyMatch，避免写这么多次。下次优化.
        // 将 isXXX 抽象为 condition 接口
        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            if(!isSimpleForSingle(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean containsSimple(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            if(isSimple(c)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isTraditional(char c) {
        String sc = String.valueOf(c);
        return isTraditionalForSingle(sc);
    }

    private boolean isTraditionalForSingle(String c) {
        if(!isChinese(c)) {
            return false;
        }

        // 繁体字符包含
        return this.dataMap.tChars().contains(c);
    }

    @Override
    public boolean isTraditional(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            if(!isTraditionalForSingle(c)) {
                return false;
            }
        }

        //3. 返回
        return true;
    }

    @Override
    public boolean containsTraditional(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            if(isTraditional(c)) {
                return true;
            }
        }

        //3. 返回
        return false;
    }

    @Override
    public boolean isChinese(char c) {
        // 单个字符，直接简单判断
        return CharUtil.isChinese(c);
    }

    @Override
    public boolean isChinese(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        // 遍历
        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            // 兼容双字符
            if(!InnerCharUtils.isChineseForSingle(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean containsChinese(String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        // 遍历
        List<String> chars = toCharList(charOrPhrase);
        for(String c : chars) {
            if(this.isChinese(c)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> toSimple(char c) {
        return dataMap.tsChar().get(String.valueOf(c));
    }

    @Override
    public List<String> toTraditional(char c) {
        return dataMap.stChar().get(String.valueOf(c));
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
    protected String convert(final String original,
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
