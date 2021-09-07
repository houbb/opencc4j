package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.MapUtil;
import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 2018/2/11
 *
 * 数据文件工具类
 * 1. 此类设置为包可访问，禁止外部使用。后期可能会改变。
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
final class DataUtil {

    private DataUtil(){}

    /**
     * 构建数据集合
     *
     * 后期考虑：是否允许用户自定义字典？
     * 目前不支持这些操作。后期如果需要，再把这些限制放开。
     * @param path 文件路径
     * @return 返回数据集合
     * @see Collections#unmodifiableMap(Map) 保证字典数据不被外部修改
     */
    static Map<String, List<String>> buildDataMap(final String path) {
        try(InputStream is = DataUtil.class.getResourceAsStream(path);
            BufferedReader e = new BufferedReader(new InputStreamReader(is, Charset.forName(AppConstant.DEFAULT_CHARSET)))) {
            Map<String, List<String>> map = new HashMap<>();
            while (e.ready()) {
                String entry = e.readLine();
                if (StringUtil.isEmpty(entry)) {
                    continue;
                }
                String[] strings = StringUtil.splitByAnyBlank(entry);

                // 构建值
                List<String> values = buildValueList(strings);
                if(CollectionUtil.isNotEmpty(values)) {
                    map.put(strings[0], values);
                }
            }
            return map;
        } catch (IOException e) {
            throw new Opencc4jRuntimeException("Dict 数据加载失败!", e);
        }
    }

    /**
     * 构建值列表
     * @param strings 字符串列表
     * @return 结果列表
     * @since 1.6.0
     */
    private static List<String> buildValueList(final String[] strings) {
        List<String> resultList = new ArrayList<>();

        for(int i = 1; i < strings.length; i++) {
            String value = strings[i];
            if(!AppConstant.EMPTY_RESULT.equals(value)) {
                resultList.add(value);
            }
        }

        return resultList;
    }

    /**
     * 构建数据集合-逆向
     *
     * 后期考虑：是否允许用户自定义字典？
     * 目前不支持这些操作。后期如果需要，再把这些限制放开。
     * @param path 文件路径
     * @return 返回数据集合
     * @see Collections#unmodifiableMap(Map) 保证字典数据不被外部修改
     * @since 1.7.0
     */
    static Map<String, List<String>> buildDataMapReverse(final String path) {
        try(InputStream is = DataUtil.class.getResourceAsStream(path);
            BufferedReader e = new BufferedReader(new InputStreamReader(is, Charset.forName(AppConstant.DEFAULT_CHARSET)))) {
            Map<String, List<String>> map = new HashMap<>();
            while (e.ready()) {
                String entry = e.readLine();
                if (StringUtil.isEmpty(entry)) {
                    continue;
                }
                String[] strings = StringUtil.splitByAnyBlank(entry);

                // 构建值
                List<String> values = buildValueListReverse(strings);
                if(CollectionUtil.isNotEmpty(values)) {
                    map.put(strings[strings.length-1], values);
                }
            }
            return map;
        } catch (IOException e) {
            throw new Opencc4jRuntimeException("Dict 数据加载失败!", e);
        }
    }

    /**
     * 构建值列表-逆向
     *
     * @param strings 字符串列表
     * @return 结果列表
     * @since 1.7.0
     */
    private static List<String> buildValueListReverse(final String[] strings) {
        List<String> resultList = new ArrayList<>();

        for(int i = strings.length-1; i > 0; i--) {
            String value = strings[i];
            if(!AppConstant.EMPTY_RESULT.equals(value)) {
                resultList.add(value);
            }
        }

        return resultList;
    }

    /**
     * 合并： 用其他数据合并当前的数据
     *
     * @param data 数据
     * @param dataOther 其他数据
     * @since 1.7.0
     * @author jackychu0830
     */
    public static void merge(Map<String, List<String>> data,
                             Map<String, List<String>> dataOther) {
        if(MapUtil.isEmpty(dataOther)) {
            return;
        }

        for(Map.Entry<String,List<String>> entry : dataOther.entrySet()) {
            data.put(entry.getKey(), entry.getValue());
        }
    }

}
