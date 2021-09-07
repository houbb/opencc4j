package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.util.ZhConverterUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 台灣正體用語詞組
 * @author Jacky Chu
 * @since 1.6.3
 */
@ThreadSafe
public class STwPhraseData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (STwPhraseData.class) {
            DATA_INFO = new DataInfo();

            // 原始簡轉繁詞組
            Map<String, List<String>> data = new java.util.HashMap<>(DataUtil.buildDataMap("/data/dictionary/STPhrases.txt"));

            // 台灣 IT 用詞
            Map<String, List<String>> twIt = DataUtil.buildDataMap("/data/dictionary/TWPhrasesIT.txt");
            DataUtil.merge(data, twIt);

            // 台灣地名用詞
            Map<String, List<String>> twName = DataUtil.buildDataMap("/data/dictionary/TWPhrasesName.txt");
            DataUtil.merge(data, twName);

            // 台灣其他用詞
            Map<String, List<String>> twOther = DataUtil.buildDataMap("/data/dictionary/TWPhrasesOther.txt");
            DataUtil.merge(data, twOther);

            DATA_INFO.setDataMap(Collections.unmodifiableMap(data));
            DATA_INFO.setName("繁體轉台灣正體用語詞組");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }
}
