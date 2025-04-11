package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

import java.util.List;

/**
 * 匹配任何一个
 * @since 1.11.0
 */
public class SimpleZhMatchAny extends AbstractZhMatchAny {

    @Override
    protected boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context) {
        return super.isSimple(chars, context);
    }

}
