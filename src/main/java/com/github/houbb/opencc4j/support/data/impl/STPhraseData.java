package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.List;
import java.util.Map;

/**
 * 简写=》繁写 词组
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class STPhraseData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (STPhraseData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/STPhrases.txt");
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("简体转繁体词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
