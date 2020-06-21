package com.github.houbb.opencc4j.support.convert.context;

import java.util.List;
import java.util.Map;

/**
 * 中文转换上下文接口
 * @author binbin.hou
 * @since 1.1.0
 */
public interface UnitConvertContext {

    /**
     * 获取原始单元(词/词组)
     * @return 原始字符串
     */
    String getUnit();

    /**
     * 获取字符数据
     * @return 数据
     */
    Map<String, List<String>> getCharData();

    /**
     * 获取词组数据
     * @return 词组数据
     */
    Map<String, List<String>> getPhraseData();

}
