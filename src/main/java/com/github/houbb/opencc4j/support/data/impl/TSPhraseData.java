package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.List;
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
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TSPhraseData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/TSPhrases.txt");
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("中国大陆繁体转简体词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
