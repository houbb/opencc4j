package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.*;

/**
 * 抽象数据数据 map 接口
 *
 * @author binbin.hou
 * @since 1.8.0
 */
public abstract class AbstractDataMap implements IDataMap {

    /**
     * 繁体字符
     */
    private volatile Set<String> tSet = new HashSet<>();
    /**
     * 简体字符
     */
    private volatile Set<String> sSet = new HashSet<>();

    // 当今大陆习惯使用简体，所以人们对繁体比较敏感
    // 为了便于拓展，暂时不写死。不做提前生成，降低初始化耗时，换来一定的灵活性。
    // 把所有的繁体放在里面，其他的中文但不是繁体认为是简体。
    @Override
    public synchronized Set<String> tChars() {
        //DLC-保证只初始化一次
        if(CollectionUtil.isNotEmpty(tSet)) {
            return tSet;
        }

        if(CollectionUtil.isEmpty(tSet)) {
            synchronized (tSet) {
                // DLC
                if(CollectionUtil.isEmpty(tSet)) {
                    // 繁体=》简体 词组
                    Map<String, List<String>> tsPhrase = this.tsPhrase();
                    this.addCharToSet(tSet, tsPhrase.keySet());

                    //繁体=》简体 单个字
                    Map<String, List<String>> tsChar = this.tsChar();
                    this.addCharToSet(tSet, tsChar.keySet());

                    //简体=》繁体 词组
                    Map<String, List<String>> stPhrase = this.stPhrase();
                    for(Map.Entry<String, List<String>> entry : stPhrase.entrySet()) {
                        this.addCharToSet(tSet, entry.getValue());
                    }

                    //简体=》繁体 单个字
                    Map<String, List<String>> stChar = this.stChar();
                    for(Map.Entry<String, List<String>> entry : stChar.entrySet()) {
                        this.addCharToSet(tSet, entry.getValue());
                    }

                    // 文本字典
                    List<String> tcLines = StreamUtil.readAllLines("/data/dictionary/tc.txt");
                    for(String line : tcLines) {
                        tSet.addAll(StringUtil.toCharStringList(line));
                    }
                }
            }
        }

        return tSet;
    }

    @Override
    public synchronized Set<String> sChars() {
        //DLC-保证只初始化一次
        if(CollectionUtil.isNotEmpty(sSet)) {
            return sSet;
        }

        if(CollectionUtil.isEmpty(sSet)) {
            synchronized (sSet) {
                // DLC
                if(CollectionUtil.isEmpty(sSet)) {
                    // 繁体=》简体 词组
                    Map<String, List<String>> tsPhrase = this.tsPhrase();
                    for(Map.Entry<String, List<String>> entry : tsPhrase.entrySet()) {
                        this.addCharToSet(sSet, entry.getValue());
                    }

                    //繁体=》简体 单个字
                    Map<String, List<String>> tsChar = this.tsChar();
                    for(Map.Entry<String, List<String>> entry : tsChar.entrySet()) {
                        this.addCharToSet(sSet, entry.getValue());
                    }

                    //简体=》繁体 词组
                    Map<String, List<String>> stPhrase = this.stPhrase();
                    this.addCharToSet(sSet, stPhrase.keySet());

                    //简体=》繁体 单个字
                    Map<String, List<String>> stChar = this.stChar();
                    this.addCharToSet(sSet, stChar.keySet());

                    // 文本字典
                    List<String> tcLines = StreamUtil.readAllLines("/data/dictionary/sc.txt");
                    for(String line : tcLines) {
                        sSet.addAll(StringUtil.toCharStringList(line));
                    }
                }
            }
        }

        return sSet;
    }

    /**
     * 字符添加到集合中
     * @param resultSet 结果集合
     * @param charOrPhraseCollection 字符或者是词组集合
     */
    protected void addCharToSet(Set<String> resultSet, Collection<String> charOrPhraseCollection) {
        if(CollectionUtil.isEmpty(charOrPhraseCollection)) {
            return;
        }

        for(String charOrPhrase : charOrPhraseCollection) {
            this.addCharToSet(resultSet, charOrPhrase);
        }
    }

    /**
     * 字符添加到集合中
     * @param resultSet 结果集合
     * @param charOrPhrase 字符或者是词组
     */
    protected void addCharToSet(Set<String> resultSet, String charOrPhrase) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return;
        }

        char[] chars = charOrPhrase.toCharArray();
        for(char c : chars) {
            resultSet.add(c+"");
        }
    }

}
