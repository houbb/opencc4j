package com.github.houbb.opencc4j.model.data;

import java.util.List;
import java.util.Map;

/**
 * 中文数据信息
 * 1. 使用对象代替原来的 map，便于后续拓展。
 * @author binbin.hou
 * @since 1.1.0
 */
public class DataInfo {

    /**
     * 数据名称
     */
    private String name;

    /**
     * 文件数据
     */
    private Map<String, List<String>> dataMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<String>> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, List<String>> dataMap) {
        this.dataMap = dataMap;
    }

}
