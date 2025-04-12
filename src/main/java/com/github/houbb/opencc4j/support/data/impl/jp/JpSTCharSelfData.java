package com.github.houbb.opencc4j.support.data.impl.jp;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;

import java.util.List;
import java.util.Map;

/**
 * 标准繁体==》新日文
 *
 * @author binbin.hou
 * @since 1.11.0
 */
public class JpSTCharSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        DATA_INFO = new DataInfo();
        Map<String, List<String>> dataTw = DataUtil.buildDataMap("/data/dictionary/JPVariants.txt");
        DATA_INFO.setDataMap(dataTw);
        DATA_INFO.setName("标准繁体到新日文自身数据");
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
