package com.github.houbb.opencc4j.support.segment.trie;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.nlp.common.dfa.tree.impl.AbstractTrieTreeMap;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 其实这里可以默认联动掉，避免用户使用错误。
 *
 * <p> project: pinyin-DefaultPinyinTrieMap </p>
 * <p> create on 2020/2/7 17:39 </p>
 *
 * @author binbin.hou
 * @since 1.9.0
 */
@ThreadSafe
public class DataMapTrieTreeMap extends AbstractTrieTreeMap {

    private final IDataMap dataMap;
    /**
     * 内部 map
     */
    private static volatile Map innerWordMap = Guavas.newHashMap();

    public DataMapTrieTreeMap(IDataMap dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    protected Map getStaticVolatileMap() {
        return innerWordMap;
    }

    @Override
    protected Collection<String> getWordCollection() {
        Set<String> resultSet = Guavas.newHashSet();

        //1. 简体词组的 keys
        resultSet.addAll(dataMap.stPhrase().keySet());

        //2. 繁体词组的 keys
        resultSet.addAll(dataMap.tsPhrase().keySet());

        return resultSet;
    }

}
