package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.Data;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;
import com.github.houbb.opencc4j.support.data.impl.hk.HkTSCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.jp.JpSTCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.jp.JpTSCharReverseSelfData;
import com.github.houbb.opencc4j.support.data.impl.jp.JpTSShinjitaiCharSelfData;
import com.github.houbb.opencc4j.support.data.impl.jp.JpTSShinjitaiPhrasesSelfData;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 中国日本自身数据 map 接口
 *
 * @author binbin.hou
 * @since 1.13.0
 */
@ThreadSafe
public class DataMapJpSelf extends AbstractDataMap {

    @Override
    public Map<String, List<String>> tsPhrase() {
        final Data data = new JpTSShinjitaiPhrasesSelfData();
        return data.data().getDataMap();
    }

    @Override
    public Map<String, List<String>> tsChar() {
        // 两个简体
        final Data jpTSShinjitaiCharSelfData = new JpTSShinjitaiCharSelfData();
        final Data jpTSCharReverseSelfData = new JpTSCharReverseSelfData();

        return DataUtil.merge(jpTSShinjitaiCharSelfData.data().getDataMap(), jpTSCharReverseSelfData.data().getDataMap());
    }

    @Override
    public Map<String, List<String>> stPhrase() {
        // 没有
        return Collections.emptyMap();
    }

    @Override
    public Map<String, List<String>> stChar() {
        final Data data = new JpSTCharSelfData();
        return data.data().getDataMap();
    }

}
