package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.util.ZhConverterUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 台灣異體字
 * @author Jacky Chu
 * @since 1.6.3
 */
@ThreadSafe
public class STwCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (STwCharData.class) {
            DATA_INFO = new DataInfo();

            // 原始簡轉繁字元
            Map<String, List<String>> data = new java.util.HashMap<>(DataUtil.buildDataMap("/data/dictionary/STCharacters.txt"));

            // 台灣異體字
            Map<String, List<String>> twVar = DataUtil.buildDataMap("/data/dictionary/TWVariants.txt");
            DataUtil.merge(data, twVar);

            DATA_INFO.setDataMap(Collections.unmodifiableMap(data));
            DATA_INFO.setName("繁體轉台灣異體字元");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
