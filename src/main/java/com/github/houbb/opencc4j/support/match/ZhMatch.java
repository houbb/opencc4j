package com.github.houbb.opencc4j.support.match;

import com.github.houbb.opencc4j.core.ZhConvertCoreContext;

/**
 * 匹配策略
 *
 * @since 1.11.0
 */
public interface ZhMatch {

    /**
     * 匹配结果
     * @param text 文本
     * @param context 上下文
     * @return 结果
     */
    boolean match(final String text,
                  final ZhConvertCoreContext context);

}
