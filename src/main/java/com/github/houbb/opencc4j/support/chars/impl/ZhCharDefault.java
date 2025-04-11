package com.github.houbb.opencc4j.support.chars.impl;

import com.github.houbb.opencc4j.support.chars.ZhChar;
import com.github.houbb.opencc4j.util.InnerCharUtils;

import java.util.List;

/**
 * @since 1.10.0
 */
public class ZhCharDefault implements ZhChar {

    /**
     * 文本转对应的 char 数组
     *
     * @param text 文本
     * @return 结果
     */
    public List<String> chars(final String text) {
        return InnerCharUtils.toCharList(text);
    }

}
