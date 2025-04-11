package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

/**
 * 匹配任何一个
 * @since 1.11.0
 */
public class TraditionalZhMatchAny extends AbstractZhMatchAny {

    @Override
    protected boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context) {
        return super.isTraditional(chars, context);
    }

}
