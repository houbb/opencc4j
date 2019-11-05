package com.github.houbb.opencc4j.support.convert.core.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.support.convert.context.UnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;

import java.util.Map;

/**
 * 默认的中文单个词组/单词转换实现
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public class DefaultUnitConvert implements UnitConvert {

    @Override
    public String convert(UnitConvertContext context) {
        final String unit = context.getUnit();
        final Map<String, String> charMap = context.getCharData();
        final Map<String, String> phaseMap = context.getPhraseData();
        return this.getPhraseResult(unit, phaseMap, charMap);
    }

    /**
     * 对于词组的转换
     *
     * @param original original
     * @param phraseMap 词组集合
     * @param charMap  单个单词集合
     * @return java.lang.String
     */
    private String getPhraseResult(final String original,
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
