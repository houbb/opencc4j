package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.util.util.MapUtil;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象数据数据 map 接口-拓展接口
 *
 * @author binbin.hou
 * @since 1.9.0
 */
public abstract class AbstractDataMapExtra extends AbstractDataMap {

    private final IDataMap baseDataMap;

    /**
     * 避免多次初始化
     * @since 0.13.1
     */
    private volatile Map<String, List<String>> tsPhrase;
    private volatile Map<String, List<String>> tsChar;
    private volatile Map<String, List<String>> stPhrase;
    private volatile Map<String, List<String>> stChar;

    public AbstractDataMapExtra(IDataMap baseDataMap) {
        this.baseDataMap = baseDataMap;
    }

    /**
     * 繁体-》简体 词组
     * @return 结果
     */
    protected abstract Map<String, List<String>> tsPhraseExtra();
    /**
     * 繁体-》简体 单个字
     * @return 结果
     */
    protected abstract Map<String, List<String>> tsCharExtra();
    /**
     * 简体-》繁体 词组
     * @return 结果
     */
    protected abstract Map<String, List<String>> stPhraseExtra();

    /**
     * 简体-》繁体 单个字
     * @return 结果
     */
    protected abstract Map<String, List<String>> stCharExtra();


    @Override
    public synchronized Map<String, List<String>> tsPhrase() {
        if(tsPhrase != null) {
            return tsPhrase;
        }

        tsPhrase = buildAllMap(baseDataMap.tsPhrase(), tsPhraseExtra());

        return tsPhrase;
    }

    @Override
    public synchronized Map<String, List<String>> tsChar() {
        if(tsChar != null) {
            return tsChar;
        }

        tsChar = buildAllMap(baseDataMap.tsChar(), tsCharExtra());
        return tsChar;
    }

    @Override
    public synchronized Map<String, List<String>> stPhrase() {
        if(stPhrase != null) {
            return stPhrase;
        }

        stPhrase = buildAllMap(baseDataMap.stPhrase(), stPhraseExtra());

        return stPhrase;
    }

    @Override
    public synchronized Map<String, List<String>> stChar() {
        if(stChar != null) {
            return stChar;
        }

        stChar = buildAllMap(baseDataMap.stChar(), stCharExtra());
        return stChar;
    }

    protected Map<String, List<String>> buildAllMap(Map<String, List<String>> base, Map<String, List<String>> extra) {
        if(MapUtil.isEmpty(extra)) {
            return base;
        }

        Map<String, List<String>> resultMap = new HashMap<>();
        if(MapUtil.isNotEmpty(base)) {
            resultMap.putAll(base);
        }
        resultMap.putAll(extra);
        return resultMap;
    }
}
