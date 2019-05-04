package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.model.data.DataInfo;

import java.util.Map;

/**
 * 繁体=》简体 字符
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class T2SCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static DataInfo dataInfo;

    static {
        synchronized (T2SCharData.class) {
            dataInfo = new DataInfo();

            Map<String, String> data = DataUtil.buildDataMap("/data/dictionary/TSCharacters.txt");
            dataInfo.setDataMap(data);
            dataInfo.setName("繁体转简体字符数据");
        }
    }

    @Override
    public DataInfo data() {
        return dataInfo;
    }

}
