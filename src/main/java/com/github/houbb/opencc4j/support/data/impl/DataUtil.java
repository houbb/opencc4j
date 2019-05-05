package com.github.houbb.opencc4j.support.data.impl;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;
import com.github.houbb.opencc4j.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    static Map<String, String> buildDataMap(final String path) {
        try {
            Map<String, String> map = new HashMap<>();
            InputStream is = DataUtil.class.getResourceAsStream(path);
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
            return Collections.unmodifiableMap(map);
        } catch (IOException e) {
            throw new Opencc4jRuntimeException("Dict 数据加载失败!", e);
        }
    }

}
