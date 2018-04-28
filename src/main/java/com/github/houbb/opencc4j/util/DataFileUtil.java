package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.support.exception.Opencc4jRuntimeException;
import com.github.houbb.paradise.common.util.MapUtil;
import com.github.houbb.paradise.common.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2018/2/11
 *
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public final class DataFileUtil {

    /**
     * 对于数据的加载是固定的
     */
    private static Map<String, Map<String, String>> DATA_MAP = new ConcurrentHashMap<>();

    private DataFileUtil(){}

    /**
     * 构建数据 map
     * @param path 文件路径
     * @return 数据 map
     */
    public static Map<String, String> getDataMap(final String path) {
        Map<String, String> map = DATA_MAP.get(path);
        if(MapUtil.isNotEmpty(map)) {
            return map;
        }
        return buildDataMap(path);
    }

    /**
     * 构建数据集合
     * @param path 文件路径
     * @return 返回数据集合
     */
    private static Map<String, String> buildDataMap(final String path) {
        try {
            Map<String, String> map = new HashMap<>();
            InputStream is = DataFileUtil.class.getResourceAsStream(path);
            BufferedReader e = new BufferedReader(new InputStreamReader(is,
                    Charset.forName(AppConstant.DEFAULT_CHARSET)));

            while (e.ready()) {
                String entry = e.readLine();
                if (StringUtil.isEmpty(entry)) {
                    continue;
                }
                String[] strings = StringUtil.splitByAnyBlank(entry);
                map.put(strings[0], strings[1]);
            }

            DATA_MAP.put(path, map);
            return map;
        } catch (IOException e) {
            throw new Opencc4jRuntimeException(e);
        }
    }

}
