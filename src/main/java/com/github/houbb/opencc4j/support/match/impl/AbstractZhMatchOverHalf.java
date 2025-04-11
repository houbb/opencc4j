package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

import java.util.List;

/**
 * 超过一半
 * @since 1.11.0
 */
public abstract class AbstractZhMatchOverHalf extends AbstractZhMatch {

    protected abstract boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context);

    @Override
    protected boolean doMatch(String text, List<String> chars, ZhConvertCoreContext context) {
        int matchCount = 0;

        for(String charSeg : chars) {
            if(matchCondition(text, charSeg, context)) {
                matchCount++;
            }
        }

        int totalSize = chars.size();
        if(matchCount * 2 > totalSize) {
            return true;
        }
        return false;
    }

}
