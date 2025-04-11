package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.Data;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.data.impl.hk.HkSTCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.hk.HkSTPhraseSelfData;
import com.github.houbb.opencc4j.support.data.impl.hk.HkTSCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.hk.HkTSPhraseSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwSTCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwSTPhraseSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwTSCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwTSPhraseSelfData;

import java.util.List;
import java.util.Map;

/**
 * 中国香港自身数据 map 接口
 *
 * @author binbin.hou
 * @since 1.12.0
 */
@ThreadSafe
public class DataMapHkSelf extends AbstractDataMap {

    @Override
    public Map<String, List<String>> tsPhrase() {
        final Data data = new HkTSPhraseSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> tsChar() {
        final Data data = new HkTSCharSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stPhrase() {
        final Data data = new HkSTPhraseSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stChar() {
        final Data data = new HkSTCharSelfData();
        return data.data().getDataMap();
    }
}
