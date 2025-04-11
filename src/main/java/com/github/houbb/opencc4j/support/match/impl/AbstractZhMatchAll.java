package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

import java.util.List;

/**
 * 全部匹配
 * @since 1.11.0
 */
public abstract class AbstractZhMatchAll extends AbstractZhMatch {

    protected abstract boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context);

    @Override
    protected boolean doMatch(String text, List<String> chars, ZhConvertCoreContext context) {

        for(String charSeg : chars) {
            if(!matchCondition(text, charSeg, context)) {
                return false;
            }
        }

        return true;
    }

}
