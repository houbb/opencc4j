package com.github.houbb.opencc4j.core;

import com.github.houbb.opencc4j.support.chars.ZhChar;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.segment.Segment;

/**
 * 转换上下文
 *
 * @author houbinbin
 * @since 1.10.0
 */
public class ZhConvertCoreContext {

    /**
     * 指定分词实现
     */
    private Segment segment;

    /**
     * 数据集合实现
     */
    private IDataMap dataMap;

    /**
     * 单个转换实现
     */
    private UnitConvert unitConvert;

    /**
     * 中文字符策略
     */
    private ZhChar zhChars;

    public static ZhConvertCoreContext newInstance() {
        return new ZhConvertCoreContext();
    }

    public Segment segment() {
        return segment;
    }

    public ZhConvertCoreContext segment(Segment segment) {
        this.segment = segment;
        return this;
    }

    public IDataMap dataMap() {
        return dataMap;
    }

    public ZhConvertCoreContext dataMap(IDataMap dataMap) {
        this.dataMap = dataMap;
        return this;
    }

    public UnitConvert unitConvert() {
        return unitConvert;
    }

    public ZhConvertCoreContext unitConvert(UnitConvert unitConvert) {
        this.unitConvert = unitConvert;
        return this;
    }

    public ZhChar zhChars() {
        return zhChars;
    }

    public ZhConvertCoreContext zhChars(ZhChar zhChars) {
        this.zhChars = zhChars;
        return this;
    }
}
