package com.github.houbb.opencc4j.support.data.impl.hk;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;

import java.util.List;
import java.util.Map;

/**
 * 中国香港 简写=》繁写 词组
 * @author binbin.hou
 * @since 1.12.0
 */
@ThreadSafe
public class HkSTPhraseSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (HkSTPhraseSelfData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> dataTw = DataUtil.buildDataMap("/data/dictionary/HKVariantsRevPhrases.txt");
            DATA_INFO.setDataMap(dataTw);
            DATA_INFO.setName("中国香港简体转繁体自身词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
