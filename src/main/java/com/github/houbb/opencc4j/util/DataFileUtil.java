package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;
import com.github.houbb.paradise.common.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 2018/2/11
 *
 * 数据文件工具类
 * 1. 为了保证性能，在项目启动的时候，将词组文件加载到内存中去，且只加载一次。
 * 2. 此处不用分词，性能更好。
 * @author houbinbin
 * @version 1.0
 * @since 1.7
 */
public final class DataFileUtil {

    private DataFileUtil(){}

    /**
     * 简写=》繁写 字符 Map
     */
    private static Map<String, String> S2T_CHAR_MAP;
    /**
     * 简写=》繁写 词组 Map
     */
    private static Map<String, String> S2T_PHASE_MAP;
    /**
     * 繁写=》简写 字符 Map
     */
    private static Map<String, String> T2S_CHAR_MAP;
    /**
     * 繁写=》简写 词组 Map
     */
    private static Map<String, String> T2S_PHASE_MAP;

    static {
        synchronized (DataFileUtil.class) {
            S2T_CHAR_MAP = buildDataMap(AppConstant.SimpleToTraditional.CHAR_PATH);
            S2T_PHASE_MAP = buildDataMap(AppConstant.SimpleToTraditional.PHRASE_PATH);
            T2S_CHAR_MAP = buildDataMap(AppConstant.TraditionalToSimple.CHAR_PATH);
            T2S_PHASE_MAP = buildDataMap(AppConstant.TraditionalToSimple.PHRASE_PATH);
        }
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
            return map;
        } catch (IOException e) {
            throw new Opencc4jRuntimeException("Dict 数据加载失败!", e);
        }
    }


    /**
     * 获取简体=》繁体的转换结果
     * @param original 原始信息
     * @return 繁体
     */
    public static String getS2TResult(final String original) {
        return getPhaseResult(original, S2T_PHASE_MAP, S2T_CHAR_MAP);
    }

    /**
     * 获取繁体=》简体的转换结果
     * @param original 原始信息
     * @return 简体
     */
    public static String getT2SResult(final String original) {
        return getPhaseResult(original, T2S_PHASE_MAP, T2S_CHAR_MAP);
    }


    /**
     * 对于词组的转换
     *
     * @param original original
     * @return java.lang.String
     */
    private static String getPhaseResult(final String original,
                                  final Map<String, String> phraseMap,
                                  final Map<String, String> charMap) {
        String phrase = phraseMap.get(original);
        if(StringUtil.isNotEmpty(phrase)
                && !AppConstant.EMPTY_RESULT.equals(phrase)) {
            return phrase;
        }

        char[] chars = original.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : chars) {
            String result = getCharResult(Character.toString(c), charMap);
            stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }

    /**
     * 对于单个生词的转换
     *
     * @param original original
     * @param charMap 字符集合
     * @return java.lang.String
     */
    private static String getCharResult(final String original, final Map<String, String> charMap) {
        String c = charMap.get(original);
        if(StringUtil.isNotEmpty(c)
                && !AppConstant.EMPTY_RESULT.equals(c)) {
            return c;
        }
        return original;
    }

}
