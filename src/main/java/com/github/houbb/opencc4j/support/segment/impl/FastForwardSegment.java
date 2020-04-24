package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.common.segment.ICommonSegment;
import com.github.houbb.nlp.common.segment.impl.CommonSegments;
import com.github.houbb.opencc4j.support.segment.trie.OpenccTrieTreeMap;

import java.util.List;

/**
 * 快速向前算法
 *
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class FastForwardSegment extends AbstractSegment {

    /**
     * 默认分词实现
     * @since 0.1.5
     */
    private static final ICommonSegment SEGMENT = CommonSegments.fastForward(new OpenccTrieTreeMap());

    @Override
    protected List<String> doSeg(String original) {
        return SEGMENT.segment(original);
    }

}
