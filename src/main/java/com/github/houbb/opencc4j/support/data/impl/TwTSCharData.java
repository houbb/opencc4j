package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.Data;

import java.util.List;
import java.util.Map;

/**
 * 中国台湾 繁体=》简体 字符
 * @author binbin.hou
 * @author jackychu0830
 * @since 1.7.0
 */
@ThreadSafe
public class TwTSCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TwTSCharData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/TSCharacters.txt");
            Map<String, List<String>> dataTw = DataUtil.buildDataMapReverse("/data/dictionary/TWVariants.txt");
            DataUtil.merge(data, dataTw);
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("中国台湾繁体转简体字符数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
