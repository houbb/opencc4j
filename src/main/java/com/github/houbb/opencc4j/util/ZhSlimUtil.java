package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.collection.Char2CharMap;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;

import java.util.List;
import java.util.Map;

/**
 * 中文转换简化版
 *
 * @since 1.14.0
 */
public final class ZhSlimUtil {

    private ZhSlimUtil(){}

    private static final Char2CharMap char2CharMap;

    static {
        int size = 100;
        TSCharData tsCharData = new TSCharData();
        DataInfo dataInfo = tsCharData.data();
        Map<String, List<String>> dataList = dataInfo.getDataMap();

        // 这里如果有多个，只看第一个
        // 如果超过2个 char，直接跳过
        char2CharMap = new Char2CharMap(dataList.size());
        for(Map.Entry<String, List<String>> entry : dataList.entrySet()) {
            String key = entry.getKey();
            List<String> valueList = entry.getValue();
            char[] keys = key.toCharArray();
            char[] values = valueList.get(0).toCharArray();
            if(keys.length > 1 || values.length > 1) {
                continue;
            }

            char2CharMap.put(keys[0], values[0]);
        }
    }

    /**
     * 简化版本
     * @param c 字符
     * @return 对应字符
     */
    public static char toSimple(final char c) {
        return char2CharMap.get(c, c);
    }

}
