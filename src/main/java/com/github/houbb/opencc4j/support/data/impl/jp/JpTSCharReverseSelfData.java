package com.github.houbb.opencc4j.support.data.impl.jp;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;
import com.github.houbb.opencc4j.support.data.impl.hk.HkTSCharSelfData;

import java.util.List;
import java.util.Map;

/**
 *
 * @author binbin.hou
 * @since 1.13.0
 */
@ThreadSafe
public class JpTSCharReverseSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (HkTSCharSelfData.class) {
            DATA_INFO = new DataInfo();
            Map<String, List<String>> dataTw = DataUtil.buildDataMapReverse("/data/dictionary/JPVariants.txt");
            DATA_INFO.setDataMap(dataTw);
            DATA_INFO.setName("新日文到标准繁体自身数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
