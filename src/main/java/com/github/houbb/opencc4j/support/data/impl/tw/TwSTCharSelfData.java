package com.github.houbb.opencc4j.support.data.impl.tw;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;

import java.util.List;
import java.util.Map;

/**
 * 中国台湾 简写=》繁写 字符
 *
 * @author binbin.hou
 * @since 1.12.0
 */
public class TwSTCharSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        DATA_INFO = new DataInfo();
        Map<String, List<String>> data = DataUtil.buildDataMap("/data/dictionary/TWVariants.txt");
        DATA_INFO.setDataMap(data);
        DATA_INFO.setName("中国台湾简体转繁体字符自身数据");
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
