package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.util.StringUtil;

import java.util.Map;

/**
 * 中文转换抽象类
 * @author binbin.hou
 * @since 1.1.0
 */
public abstract class AbstractZhConvert implements ZhConvert {

    @Override
    public String toSimple(String original) {
        return original;
    }

    @Override
    public String toTraditional(String original) {
        return original;
    }

    /**
     * 对于词组的转换
     *
     * @param original original
     * @return java.lang.String
     */
    protected String getPhaseResult(final String original,
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
    private String getCharResult(final String original, final Map<String, String> charMap) {
        String c = charMap.get(original);
        if(StringUtil.isNotEmpty(c)
                && !AppConstant.EMPTY_RESULT.equals(c)) {
            return c;
        }
        return original;
    }

}
