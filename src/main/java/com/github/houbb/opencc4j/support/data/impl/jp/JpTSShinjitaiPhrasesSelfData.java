package com.github.houbb.opencc4j.support.data.impl.jp;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.AbstractData;
import com.github.houbb.opencc4j.support.data.impl.DataUtil;
import com.github.houbb.opencc4j.support.data.impl.hk.HkSTPhraseSelfData;

import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.13.0
 */
public class JpTSShinjitaiPhrasesSelfData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        synchronized (HkSTPhraseSelfData.class) {
            DATA_INFO = new DataInfo();

            Map<String, List<String>> dataTw = DataUtil.buildDataMap("/data/dictionary/JPShinjitaiPhrases.txt");
            DATA_INFO.setDataMap(dataTw);
            DATA_INFO.setName("日本新日文到标准繁体自身词组数据");
        }
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
