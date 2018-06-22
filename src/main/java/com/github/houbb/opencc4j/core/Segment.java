package com.github.houbb.opencc4j.core;

import java.util.List;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/22 下午2:41  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface Segment {

    /**
     * 分词
     * @param original 原始信息
     * @return 分词后的列表
     */
    List<String> seg(final String original);

}
