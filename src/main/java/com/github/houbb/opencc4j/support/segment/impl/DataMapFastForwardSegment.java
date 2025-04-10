package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.common.segment.ICommonSegment;
import com.github.houbb.nlp.common.segment.impl.CommonSegments;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.segment.trie.DataMapTrieTreeMap;
import com.github.houbb.opencc4j.support.segment.trie.OpenccTrieTreeMap;

import java.util.List;

/**
 * 快速向前算法
 *
 * @author binbin.hou
 * @since 1.9.0
 */
@ThreadSafe
public class DataMapFastForwardSegment extends AbstractSegment {

    /**
     * 默认分词实现
     * @since 1.9.0
     */
    private ICommonSegment SEGMENT = CommonSegments.fastForward(new OpenccTrieTreeMap());

    public DataMapFastForwardSegment(IDataMap dataMap) {
        SEGMENT = CommonSegments.fastForward(new DataMapTrieTreeMap(dataMap));
    }

    @Override
    protected List<String> doSeg(String original) {
        return SEGMENT.segment(original);
    }

}
