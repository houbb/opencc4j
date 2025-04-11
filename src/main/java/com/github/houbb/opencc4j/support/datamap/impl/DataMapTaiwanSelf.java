package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.Data;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.data.impl.tw.TwSTCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwSTPhraseSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwTSCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.tw.TwTSPhraseSelfData;

import java.util.List;
import java.util.Map;

/**
 * 中国台湾数据自身 map 接口
 * <p> project: opencc4j-IDataMap </p>
 * <p> create on 2020/5/16 19:33 </p>
 *
 * @author binbin.hou
 * @since 1.12.0
 */
@ThreadSafe
public class DataMapTaiwanSelf extends AbstractDataMap {

    @Override
    public Map<String, List<String>> tsPhrase() {
        final Data data = new TwTSPhraseSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> tsChar() {
        final Data data = new TwTSCharSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stPhrase() {
        final Data data = new TwSTPhraseSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> stChar() {
        final Data data = new TwSTCharSelfData();
        return data.data().getDataMap();
    }

}
