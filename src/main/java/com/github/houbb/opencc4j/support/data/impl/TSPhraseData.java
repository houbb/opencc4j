package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.Map;

/**
 * 繁体=》简体 词组
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class TSPhraseData extends AbstractData {

    /**
     * 数据对象
     */
    private static DataInfo dataInfo;

    static {
        synchronized (TSPhraseData.class) {
            dataInfo = new DataInfo();

            Map<String, String> data = DataUtil.buildDataMap("/data/dictionary/TSPhrases.txt");
            dataInfo.setDataMap(data);
            dataInfo.setName("繁体转简体词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return dataInfo;
    }

}
