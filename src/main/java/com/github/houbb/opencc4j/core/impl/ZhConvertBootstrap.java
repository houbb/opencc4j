package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.core.ZhConvertCore;
import com.github.houbb.opencc4j.core.ZhConvertCoreContext;
import com.github.houbb.opencc4j.support.chars.ZhChar;
import com.github.houbb.opencc4j.support.chars.ZhChars;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.UnitConverts;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.Segments;

import java.util.List;

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
     * 中文字符策略
     * @since 1.10.0
     */
    private ZhChar zhChar = ZhChars.defaults();

    /**
     * 单元转换策略
     * @since 1.10.0
     */
    private UnitConvert unitConvert = UnitConverts.defaults();

    /**
     * 核心实现
     * @since 1.10.0
     */
    private ZhConvertCore zhConvertCore = new ZhConvertCoreDefault();

    /**
     * 上下文
     * @since 1.10.0
     */
    private ZhConvertCoreContext context;

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
        ArgUtil.notNull(dataMap, "dataMap");

        this.dataMap = dataMap;
        return this;
    }

    public ZhConvertBootstrap zhChar(ZhChar zhChar) {
        ArgUtil.notNull(zhChar, "zhChar");

        this.zhChar = zhChar;
        return this;
    }

    public ZhConvertBootstrap unitConvert(UnitConvert unitConvert) {
        ArgUtil.notNull(unitConvert, "unitConvert");

        this.unitConvert = unitConvert;
        return this;
    }

    /**
     * 初始化
     * @return this
     */
    public ZhConvertBootstrap init() {
        this.context = ZhConvertCoreContext
                .newInstance()
                .zhChars(zhChar)
                .segment(segment)
                .unitConvert(unitConvert)
                .dataMap(dataMap);
        return this;
    }

    @Override
    public String toSimple(String original) {
        return zhConvertCore.toSimple(original, context);
    }

    @Override
    public String toTraditional(String original) {
        return zhConvertCore.toTraditional(original, context);
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
        return zhConvertCore.simpleList(original, context);
    }

    @Override
    public List<String> traditionalList(String original) {
        return zhConvertCore.traditionalList(original, context);
    }

    @Override
    public boolean isSimple(char c) {
        return zhConvertCore.isSimple(c, context);
    }

    @Override
    public boolean isSimple(String charOrPhrase) {
        return zhConvertCore.isSimple(charOrPhrase, context);
    }

    @Override
    public boolean containsSimple(String charOrPhrase) {
        return zhConvertCore.containsSimple(charOrPhrase, context);
    }

    @Override
    public boolean isTraditional(char c) {
        return zhConvertCore.isTraditional(c, context);
    }

    @Override
    public boolean isTraditional(String charOrPhrase) {
        return zhConvertCore.isTraditional(charOrPhrase, context);
    }

    @Override
    public boolean containsTraditional(String charOrPhrase) {
        return zhConvertCore.containsTraditional(charOrPhrase, context);
    }

    @Override
    public boolean isChinese(char c) {
        return zhConvertCore.isChinese(c, context);
    }

    @Override
    public boolean isChinese(String charOrPhrase) {
        return zhConvertCore.isChinese(charOrPhrase, context);
    }

    @Override
    public boolean containsChinese(String charOrPhrase) {
        return zhConvertCore.containsChinese(charOrPhrase, context);
    }

    @Override
    public List<String> toSimple(char c) {
        return zhConvertCore.toSimple(c, context);
    }

    @Override
    public List<String> toTraditional(char c) {
        return zhConvertCore.toTraditional(c, context);
    }

}
