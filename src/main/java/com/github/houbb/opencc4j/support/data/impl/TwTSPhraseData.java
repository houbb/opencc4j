package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.List;
import java.util.Map;

/**
 * 中国台湾 繁体=》简体 词组
 * @author binbin.hou
 * @author jackychu0830
 * @since 1.7.0
 */
@ThreadSafe
public class TwTSPhraseData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TwTSPhraseData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/TSPhrases.txt");
            Map<String, List<String>> dataTw = DataUtil.buildDataMapReverse("/data/dictionary/TWPhrases.txt");
            DataUtil.merge(data, dataTw);
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("中国台湾繁体转简体词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
