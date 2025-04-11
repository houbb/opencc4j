package com.github.houbb.opencc4j.support.chars;

import java.util.List;

/**
 * @since 1.10.0
 */
public interface ZhChar {

    /**
     * 文本转对应的 char 数组
     * @param text 文本
     * @return 结果
     */
    List<String> chars(final String text);

}
