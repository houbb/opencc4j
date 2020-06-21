package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.List;
import java.util.Map;

/**
 * 简写=》繁写 字符
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class STCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        DATA_INFO = new DataInfo();
        Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/STCharacters.txt");
        DATA_INFO.setDataMap(data);
        DATA_INFO.setName("简体转繁体字符数据");
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
