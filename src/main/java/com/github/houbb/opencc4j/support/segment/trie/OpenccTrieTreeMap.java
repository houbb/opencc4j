package com.github.houbb.opencc4j.support.segment.trie;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.nlp.common.dfa.tree.impl.AbstractTrieTreeMap;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * <p> project: pinyin-DefaultPinyinTrieMap </p>
 * <p> create on 2020/2/7 17:39 </p>
 *
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class OpenccTrieTreeMap extends AbstractTrieTreeMap {

    /**
     * 内部 map
     *
     * @since 0.1.5
     */
    private static volatile Map innerWordMap = Guavas.newHashMap();

    @Override
    protected Map getStaticVolatileMap() {
        return innerWordMap;
    }

    @Override
    protected Collection<String> getWordCollection() {
        Set<String> resultSet = Guavas.newHashSet();

        //1. 简体词组的 keys
        resultSet.addAll(OpenccDatas.stPhrase().data().getDataMap().keySet());

        //2. 繁体词组的 keys
        resultSet.addAll(OpenccDatas.tsPhrase().data().getDataMap().keySet());

        return resultSet;
    }

}
