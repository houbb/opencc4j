package com.github.houbb.opencc4j.support.datamap.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.opencc4j.support.datamap.IDataMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 中国台湾繁简体转换实现策略
     * @return 实现
     * @since 1.7.0
     */
    public static IDataMap taiwan() {
        return Instances.singleton(DataMapTaiwan.class);
    }

    /**
     * 中国标准繁体==》台湾繁简体转换实现策略
     * @return 实现
     * @since 1.12.0
     */
    public static IDataMap taiwanSelf() {
        return new DataMapTaiwanSelf();
    }

    /**
     * 标准繁体 ==》香港 简体转换实现策略
     * @return 实现
     * @since 1.12.0
     */
    public static IDataMap hongKongSelf() {
        return new DataMapHkSelf();
    }

    /**
     * 中国大陆==》香港 简体转换实现策略
     * @return 实现
     * @since 1.12.0
     */
    public static IDataMap hongKong() {
        return chains(defaults(), hongKongSelf());
    }

    /**
     * 中文简体==》繁体标准==》日本
     * @return 实现
     * @since 1.13.0
     */
    public static IDataMap japan() {
        return chains(defaults(), japanSelf());
    }

    /**
     * 繁体标准==》日本
     * @return 实现
     * @since 1.13.0
     */
    public static IDataMap japanSelf() {
        return new DataMapJpSelf();
    }

    //----------------------------------------------------------------------

    /**
     * 链式
     * @param dataMap 数据
     * @param others 其他
     * @return 结果
     * @since 1.12.0
     */
    public static IDataMap chains(final IDataMap dataMap,
                                  final IDataMap ... others) {
        List<IDataMap> dataMapList = buildDataMapList(dataMap, others);

        return new DataMapChains(dataMapList);
    }

    /**
     * 合并
     * @param dataMap 数据
     * @param others 其他
     * @return 结果
     * @since 1.12.0
     */
    public static IDataMap merge(final IDataMap dataMap,
                                  final IDataMap ... others) {
        List<IDataMap> dataMapList = buildDataMapList(dataMap, others);

        return new DataMapMerge(dataMapList);
    }

    /**
     * 合并
     * @param dataMap 数据
     * @param others 其他
     * @return 结果
     * @since 1.12.0
     */
    public static IDataMap chainsAndMerge(final IDataMap dataMap,
                                 final IDataMap ... others) {
        List<IDataMap> dataMapList = buildDataMapList(dataMap, others);

        return new DataMapChainsAndMerge(dataMapList);
    }

    private static List<IDataMap> buildDataMapList(final IDataMap dataMap,
                                            final IDataMap ... others) {
        List<IDataMap> resultList = new ArrayList<>();
        resultList.add(dataMap);
        if(ArrayUtil.isNotEmpty(others)) {
            resultList.addAll(Arrays.asList(others));
        }
        return resultList;
    }
}
