package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.common.segment.ICommonSegment;
import com.github.houbb.nlp.common.segment.impl.CommonSegments;
import com.github.houbb.opencc4j.support.segment.trie.OpenccTrieTreeMap;
import com.github.houbb.opencc4j.support.segment.trie.TwOpenccTrieTreeMap;

import java.util.List;

/**
 * 快速向前算法-中国台湾
 *
 * @author binbin.hou
 * @since 1.7.0
 */
@ThreadSafe
public class TwFastForwardSegment extends AbstractSegment {

    /**
     * 默认分词实现
     * @since 1.7.0
     */
    private static final ICommonSegment SEGMENT = CommonSegments.fastForward(new TwOpenccTrieTreeMap());

    @Override
    protected List<String> doSeg(String original) {
        return SEGMENT.segment(original);
    }

}
