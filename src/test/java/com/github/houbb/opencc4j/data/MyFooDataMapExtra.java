package com.github.houbb.opencc4j.data;

import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.datamap.impl.AbstractDataMapExtra;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFooDataMapExtra extends AbstractDataMapExtra {

    public MyFooDataMapExtra(IDataMap baseDataMap) {
        super(baseDataMap);
    }

    // 默认在基本的繁简体基础上拓展
    public MyFooDataMapExtra() {
        this(DataMaps.defaults());
    }

    private Map<String, List<String>> of(String key, List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        map.put(key, list);

        return map;
    }

    @Override
    protected Map<String, List<String>> tsPhraseExtra() {
        // 估计写了个错的，用来演示
        return of("風玥", Arrays.asList("风月"));
    }

    @Override
    protected Map<String, List<String>> tsCharExtra() {
        return null;
    }

    @Override
    protected Map<String, List<String>> stPhraseExtra() {
        // 估计写了个错的
        return of("风月", Arrays.asList("風玥"));
    }

    @Override
    protected Map<String, List<String>> stCharExtra() {
        return null;
    }

}
