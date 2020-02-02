package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
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
     * 默认分词形式
     * 1. 暂定使用花瓣分词
     * @return 默认分词
     * @since 1.4.0
     */
    public static Segment defaults() {
        return Instances.singleton(HuaBanSegment.class);
    }

}
