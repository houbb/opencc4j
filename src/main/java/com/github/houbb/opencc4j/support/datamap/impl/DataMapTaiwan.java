package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 中国台湾数据 map 接口
 * <p> project: opencc4j-IDataMap </p>
 * <p> create on 2020/5/16 19:33 </p>
 *
 * @author binbin.hou
 * @author jackychu0830
 * @since 1.7.0
 */
@ThreadSafe
public class DataMapTaiwan implements IDataMap {

    private static final Set<String> tSet;

    static {
        tSet = new HashSet<>();
        List<String> allLines = StreamUtil.readAllLines("/data/dictionary/tc.txt");
        for(String line : allLines) {
            tSet.addAll(StringUtil.toCharStringList(line));
        }
    }

    @Override
    public Map<String, List<String>> tsPhrase() {
        return OpenccDatas.twTsPhrase().data().getDataMap();
    }

    @Override
    public Map<String, List<String>> tsChar() {
        return OpenccDatas.twTsChar().data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stPhrase() {
        return OpenccDatas.twStPhrase().data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stChar() {
        return OpenccDatas.twStChar().data().getDataMap();
    }

    @Override
    public Set<String> tChars() {
        return tSet;
    }

}
