package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;

import java.util.List;
import java.util.Map;

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
public class DataMapTaiwan extends AbstractDataMap {

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

}
