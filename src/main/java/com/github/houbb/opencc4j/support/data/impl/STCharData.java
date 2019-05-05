package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.model.data.DataInfo;

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
    private static DataInfo dataInfo;

    static {
        dataInfo = new DataInfo();
        Map<String, String> data = DataUtil.buildDataMap("/data/dictionary/STCharacters.txt");
        dataInfo.setDataMap(data);
        dataInfo.setName("简体转繁体字符数据");
    }

    @Override
    public DataInfo data() {
        return dataInfo;
    }

}
