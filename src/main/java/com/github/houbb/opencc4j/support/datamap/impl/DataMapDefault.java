package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.impl.OpenccDatas;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.Map;

/**
 * 数据 map 接口
 * <p> project: opencc4j-IDataMap </p>
 * <p> create on 2020/5/16 19:33 </p>
 *
 * @author binbin.hou
 * @since 1.5.2
 */
@ThreadSafe
public class DataMapDefault implements IDataMap {

    @Override
    public Map<String, String> tsPhrase() {
        return OpenccDatas.tsPhrase().data().getDataMap();
    }

    @Override
    public Map<String, String> tsChar() {
        return OpenccDatas.tsChar().data().getDataMap();
    }

    @Override
    public Map<String, String> stPhrase() {
        return OpenccDatas.stPhrase().data().getDataMap();
    }

    @Override
    public Map<String, String> stChar() {
        return OpenccDatas.stChar().data().getDataMap();
    }

}
