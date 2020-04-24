package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.Map;

/**
 * 繁体=》简体 字符
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class TSCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (TSCharData.class) {
            DATA_INFO = new DataInfo();

            Map<String, String> data = DataUtil.buildDataMap("/data/dictionary/TSCharacters.txt");
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("繁体转简体字符数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
