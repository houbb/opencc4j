package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

/**
 * 全部匹配
 * @since 1.11.0
 */
public class SimpleZhMatchAll extends AbstractZhMatchAll {

    @Override
    protected boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context) {
        return super.isSimple(chars, context);
    }

}
