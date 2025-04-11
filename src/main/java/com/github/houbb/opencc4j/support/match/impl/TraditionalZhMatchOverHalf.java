package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

/**
 * 超过一半
 * @since 1.11.0
 */
public class TraditionalZhMatchOverHalf extends AbstractZhMatchOverHalf {

    @Override
    protected boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context) {
        return super.isTraditional(chars, context);
    }

}
