package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.core.Segment;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.core.impl.CharSegment;
import com.github.houbb.opencc4j.core.impl.HuabanSegment;
import com.github.houbb.opencc4j.core.impl.ToSimpleZhConvert;
import com.github.houbb.opencc4j.core.impl.ToTraditonZhConvert;
import com.github.houbb.paradise.common.util.CollectionUtil;
import com.github.houbb.paradise.common.util.StringUtil;

import java.util.List;

/**
 * 中文转换工具类
 * 1. 编码问题
 * 本工具类，默认支持的为 UTF-8 格式的字符串。如果格式不统一，自行处理
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public final class ZhConverterUtil {

    /**
     *  zh converter util    
     */    
    private ZhConverterUtil(){}

    /**
     * 转换为简体
     * 1. 默认使用花瓣分词
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToSimple(String original) {
        return convertToSimple(original, true);
    }

    /**
     * 转换为繁体
     * 1. 默认使用花瓣分词
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToTraditional(String original){
        return convertToTraditional(original, true);
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @param huabanSegment 是否花瓣分词
     * @return 转换后的内容
     */
    public static String convertToSimple(String original, boolean huabanSegment) {
        ZhConvert zhConvert = new ToSimpleZhConvert();
        Segment segment = getSegment(huabanSegment);
        return convert(original, segment, zhConvert);
    }

    /**
     * 转换为繁体
     * @param original 原始内容
     * @param huabanSegment 是否花瓣分词
     * @return 转换后的内容
     */
    public static String convertToTraditional(String original, boolean huabanSegment){
        ZhConvert zhConvert = new ToTraditonZhConvert();
        Segment segment = getSegment(huabanSegment);
        return convert(original, segment, zhConvert);
    }



    /**
     * 获取分词器
     * @param huabanSegment 是否使用花瓣分词
     * @return 分词器
     */
    private static Segment getSegment(boolean huabanSegment) {
        if(huabanSegment) {
            return new HuabanSegment();
        }
        return new CharSegment();
    }


    /**
     * 转换处理
     * @param original 原始信息
     * @param segment 分词方式
     * @param zhConvert 中文转换方式
     * @return 转换结果
     */
    private static String convert(final String original, Segment segment, ZhConvert zhConvert) {
        //1. fast-fail
        if(StringUtil.isEmpty(original)) {
            return original;
        }
        List<String> stringList = segment.seg(original);
        if(CollectionUtil.isEmpty(stringList)) {
            return original;
        }

        //2. 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            String result = zhConvert.convert(string);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

}
