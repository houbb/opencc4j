package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

import java.util.List;

/**
 * 超过一半
 * @since 1.11.0
 */
public class SimpleZhMatchOverHalf extends AbstractZhMatchOverHalf {

    @Override
    protected boolean matchCondition(String fullText, String chars, ZhConvertCoreContext context) {
        return super.isSimple(chars, context);
    }

}
