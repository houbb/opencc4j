package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.core.ZhConverter;
import com.github.houbb.opencc4j.util.DataFileUtil;
import com.github.houbb.paradise.common.util.StringUtil;
import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 默认中文转换
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public class DefaultZhConverter extends AbstractZhConverter {

    /**    
     * char map    
     */    
    private Map<String, String> charMap = new HashMap<>();
    /**    
     * phrase map    
     */    
    private Map<String, String> phraseMap = new HashMap<>();


    /**    
     * convert    
     *    
     * @return com.github.houbb.opencc4j.core.ZhConverter    
     */    
    @Override
    public ZhConverter convert() {
        if(null == stringBuilder
                || StringUtil.isEmpty(stringBuilder.toString())) {
            return this;
        }
        initMap();

        //1. 原始内容转换 暂时先不考虑编码问题
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        List<String> stringList = jiebaSegmenter.sentenceProcess(stringBuilder.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            String result = getTransResult(string);
            stringBuilder.append(result);
        }

        this.stringBuilder = stringBuilder;
        return this;
    }

    /**    
     * initialize map    
     */    
    private void initMap() {
        charMap = DataFileUtil.buildDataMap(config.charPath());
        phraseMap = DataFileUtil.buildDataMap(config.phrasePath());
    }


    /**    
     * get trans result    
     *    
     * @param original original    
     * @return java.lang.String    
     */    
    private String getTransResult(String original) {
        String phrase = phraseMap.get(original);
        if(StringUtil.isNotEmpty(phrase)
                && !AppConstant.EMPTY_RESULT.equals(phrase)) {
            return phrase;
        }

        char[] chars = original.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : chars) {
            String result = getSingleResult(Character.toString(c));
            stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }

    /**    
     * get single result    
     *    
     * @param original original    
     * @return java.lang.String    
     */    
    private String getSingleResult(String original) {
        String c = charMap.get(original);
        if(StringUtil.isNotEmpty(c)
                && !AppConstant.EMPTY_RESULT.equals(c)) {
            return c;
        }
        return original;
    }

}
