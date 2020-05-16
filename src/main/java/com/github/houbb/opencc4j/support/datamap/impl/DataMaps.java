package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

/**
 * <p> project: opencc4j-DataMaps </p>
 * <p> create on 2020/5/16 19:37 </p>
 *
 * @author binbin.hou
 * @since 1.5.2
 */
public final class DataMaps {

    private DataMaps(){}

    /**
     * 默认实现策略
     * @return 实现
     * @since 1.5.2
     */
    public static IDataMap defaults() {
        return Instances.singleton(DataMapDefault.class);
    }

}
