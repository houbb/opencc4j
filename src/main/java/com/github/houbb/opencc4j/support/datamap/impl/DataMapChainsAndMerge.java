package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.opencc4j.support.data.impl.DataUtil;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 抽象数据数据 map 接口-拓展接口
 *
 * @author binbin.hou
 * @since 1.12.0
 */
public class DataMapChainsAndMerge extends AbstractDataMap {

    private final List<IDataMap> dataMaps;

    public DataMapChainsAndMerge(List<IDataMap> dataMaps) {
        this.dataMaps = dataMaps;
    }

    @Override
    public Map<String, List<String>> tsPhrase() {
        List<Map<String, List<String>>> list = new ArrayList<>();
        for(IDataMap dataMap : dataMaps) {
            list.add(dataMap.tsPhrase());
        }
        return DataUtil.chainsAndMerge(list);
    }

    @Override
    public Map<String, List<String>> tsChar() {
        List<Map<String, List<String>>> list = new ArrayList<>();
        for(IDataMap dataMap : dataMaps) {
            list.add(dataMap.tsChar());
        }
        return DataUtil.chainsAndMerge(list);
    }

    @Override
    public Map<String, List<String>> stPhrase() {
        List<Map<String, List<String>>> list = new ArrayList<>();
        for(IDataMap dataMap : dataMaps) {
            list.add(dataMap.stPhrase());
        }
        return DataUtil.chainsAndMerge(list);
    }

    @Override
    public Map<String, List<String>> stChar() {
        List<Map<String, List<String>>> list = new ArrayList<>();
        for(IDataMap dataMap : dataMaps) {
            list.add(dataMap.stChar());
        }
        return DataUtil.chainsAndMerge(list);
    }

}
