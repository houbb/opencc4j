package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.List;
import java.util.Map;

/**
 * 中国台湾 简写=》繁写 词组
 * @author binbin.hou
 * @author jackychu0830
 * @since 1.7.0
 */
@ThreadSafe
public class TwSTPhraseData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TwSTPhraseData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/STPhrases.txt");
            Map<String, List<String>> dataTw = DataUtil.buildDataMap("/data/dictionary/TWPhrases.txt");
            DataUtil.merge(data, dataTw);
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("中国台湾简体转繁体词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
