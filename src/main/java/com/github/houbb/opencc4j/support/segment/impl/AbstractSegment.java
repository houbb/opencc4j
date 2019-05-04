package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.util.StringUtil;

import java.util.Collections;
import java.util.List;

/**
 * 抽象分词实现
 * @author binbin.hou
 * @since 1.1.0
 */
public abstract class AbstractSegment implements Segment {

    /**
     * 真正的分词实现
     * @param original 原始字符串
     * @return 分词后的列表
     */
    protected abstract List<String> doSeg(final String original);

    @Override
    public List<String> seg(String original) {
        if(StringUtil.isEmpty(original)) {
            return Collections.emptyList();
        }

        return this.doSeg(original);
    }

}
