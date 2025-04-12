package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
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
public final class DataUtil {

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
    public static Map<String, List<String>> buildDataMap(final String path) {
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
    public static Map<String, List<String>> buildDataMapReverse(final String path) {
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

        // 默认取第一个？
        resultList.add(strings[0]);
        return resultList;
    }

    /**
     * 直接合并
     * @param firstMap 数据集合
     * @param others 其他的
     * @since 1.12.0
     */
    public static Map<String, List<String>> merge(Map<String, List<String>> firstMap, Map<String, List<String>>... others) {
        if(ArrayUtil.isEmpty(others)) {
            return firstMap;
        }

        List<Map<String, List<String>>> allList = new ArrayList<>();
        allList.add(firstMap);
        allList.addAll(Arrays.asList(others));
        return merge(allList);
    }

    /**
     * 直接合并
     * @param allDataMap 数据集合
     * @since 1.12.0
     */
    public static Map<String, List<String>> merge(List<Map<String, List<String>>> allDataMap) {
        if(CollectionUtil.isEmpty(allDataMap)) {
            return Collections.emptyMap();
        }
        if(allDataMap.size() == 1) {
            return allDataMap.get(0);
        }

        Map<String, List<String>> resultMap = new HashMap<>();
        for(Map<String, List<String>> map : allDataMap) {
            resultMap.putAll(map);
        }
        return resultMap;
    }

    /**
     * 链式合并
     *
     * @param data 第一组数据
     * @param dataOther 其他多个字段
     * @since 1.12.0
     */
    public static Map<String, List<String>> chains(
            final Map<String, List<String>> data,
            final Map<String, List<String>>... dataOther) {
        List<Map<String, List<String>>> allList = new ArrayList<>();
        allList.add(data);
        if(ArrayUtil.isNotEmpty(dataOther)) {
            allList.addAll(Arrays.asList(dataOther));
        }
        return chains(allList);
    }

    /**
     * 链式合并
     * @since 1.12.0
     * @param dictChain chain
     * @return 结果
     */
    public static Map<String, List<String>> chains(
            final Collection<Map<String, List<String>>> dictChain) {

        if (dictChain == null || dictChain.isEmpty()) {
            return new HashMap<>();
        }

        Iterator<Map<String, List<String>>> iterator = dictChain.iterator();

        // 第一层词典作为起始数据
        Map<String, List<String>> current = iterator.next();

        // 后续层词典按顺序合并
        while (iterator.hasNext()) {
            Map<String, List<String>> nextDict = iterator.next();
            Map<String, List<String>> merged = new HashMap<String, List<String>>();

            for (Map.Entry<String, List<String>> entry : current.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                Set<String> nextCandidatesSet = new LinkedHashSet<String>();

                for (int i = 0; i < values.size(); i++) {
                    String midValue = values.get(i);
                    List<String> nextList = nextDict.get(midValue);
                    if (nextList != null && !nextList.isEmpty()) {
                        nextCandidatesSet.addAll(nextList);
                    } else {
                        // 没有映射时保留原中间值
                        nextCandidatesSet.add(midValue);
                    }
                }

                List<String> deduped = new ArrayList<String>(nextCandidatesSet);
                merged.put(key, deduped);
            }

            current = merged;
        }

        return current;
    }

    /**
     * 链式合并+直接合并
     * 1. 基础的部分链式处理
     * 2. 剩余的部分直接再合并一次
     *
     * 比如 户=》戶=》户
     * @since 1.12.0
     * @param list 列表
     * @return 结果
     */
    public static Map<String, List<String>> chainsAndMerge(
            final List<Map<String, List<String>>> list) {
        if(CollectionUtil.isEmpty(list)) {
            return Collections.emptyMap();
        }

        Map<String, List<String>> dataMap = chains(list);

        // 剩余的直接合并
        List<Map<String, List<String>>> newMergeList = new ArrayList<>();
        newMergeList.add(dataMap);
        for(int i = 1; i < list.size(); i++) {
            newMergeList.add(list.get(i));
        }

        return merge(newMergeList);
    }

}
