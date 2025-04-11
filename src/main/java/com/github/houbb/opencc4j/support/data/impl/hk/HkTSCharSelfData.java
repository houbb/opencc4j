package com.github.houbb.opencc4j.support.data.impl.hk;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;

import java.util.List;
import java.util.Map;

/**
 * 中国香港 繁体=》简体 字符
 * @author binbin.hou
 * @since 1.12.0
 */
@ThreadSafe
public class HkTSCharSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (HkTSCharSelfData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> data = DataUtil.buildDataMapReverse("/data/dictionary/TWVariants.txt");
            DATA_INFO.setDataMap(data);
            DATA_INFO.setName("中国香港繁体转简体字符自身数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
