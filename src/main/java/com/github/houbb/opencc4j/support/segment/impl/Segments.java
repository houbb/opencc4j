package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.segment.Segment;

/**
 * 分词工具类
 * @author binbin.hou
 * @since 1.4.0
 */
public final class Segments {

    private Segments(){}

    /**
     * 直接拆分为单个字符
     * @return 分词实现
     * @since 1.4.0
     */
    public static Segment chars() {
        return Instances.singleton(CharSegment.class);
    }

    /**
     * 花瓣分词
     * @return 实现
     * @since 0.1.5
     */
    public static Segment huaBan() {
        return Instances.singleton(HuaBanSegment.class);
    }

    /**
     * 快速向前算法
     * @return 算法
     * @since 0.1.5
     */
    public static Segment fastForward() {
        return Instances.singleton(FastForwardSegment.class);
    }

    /**
     * 快速向前算法-中国台湾
     * @return 算法
     * @since 1.7.0
     */
    public static Segment twFastForward() {
        return Instances.singleton(TwFastForwardSegment.class);
    }

    /**
     * 默认分词形式
     * 1. 调整为使用 fast-forward
     * @return 默认分词
     * @since 1.4.0
     */
    public static Segment defaults() {
        return fastForward();
    }

    /**
     * 默认分词形式
     * 1. 调整为使用 fast-forward
     * @return 默认分词
     * @since 1.9.0
     */
    public static Segment dataMapFastForward(final IDataMap dataMap) {
        return new DataMapFastForwardSegment(dataMap);
    }

}
