package com.github.houbb.opencc4j.support.segmentation;

import java.util.List;

/**
 * <p> 分词器-接口 </p>
 *
 * <pre> Created: 2018-04-28 11:07  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public interface Segmentation {

    /**
     * 分词
     * @param original 原始内容
     * @return 分词后的字符串列表
     */
    List<String> segmentate(final String original);

}
