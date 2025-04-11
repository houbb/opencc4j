package com.github.houbb.opencc4j.support.chars;

import com.github.houbb.opencc4j.support.chars.impl.ZhCharDefault;

/**
 * @since 1.10.0
 */
public class ZhChars {

    /**
     * 默认实现
     * @return 实现
     */
    public static ZhChar defaults() {
        return new ZhCharDefault();
    }


}
