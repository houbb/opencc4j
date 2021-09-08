package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.util.ZhConverterUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 中国台湾 简写=》繁写 字符
 *
 * @author binbin.hou
 * @author jackychu0830
 * @since 1.7.0
 */
@ThreadSafe
public class TwSTCharData extends AbstractData {

    /**
     * 数据对象
     */
    private static final DataInfo DATA_INFO;

    static {
        DATA_INFO = new DataInfo();
        Map<String, List<String>> data = new HashMap<>(DataUtil.buildDataMap("/data/dictionary/STCharacters.txt"));

        Map<String, List<String>> dataTw = DataUtil.buildDataMap("/data/dictionary/TWVariants.txt");
        for (String key : dataTw.keySet()) {
            // 先将繁体的 key 转成简体
            String sKey = ZhConverterUtil.toSimple(key);
            // 找到简体字符
            if (data.containsKey(sKey)) {
                // 取出原本的值
                List<String> values = data.get(sKey);
                // 找出符合的繁体字符，替换成异体字符
                // TWVariants.txt 只有1对1 对应，所以只取 index 0 的值
                int index = values.indexOf(key);
                if (index != -1) {
                    values.set(index, dataTw.get(key).get(0));
                }
            } else {
                // 若无对应，则新增一组
                data.put(sKey, dataTw.get(key));
            }
        }

        DATA_INFO.setDataMap(data);
        DATA_INFO.setName("中国台湾简体转繁体字符数据");
    }

    @Override
    public DataInfo data() {
        return DATA_INFO;
    }

}
