package com.github.houbb.opencc4j.support.segmentation.impl;

import com.github.houbb.opencc4j.support.segmentation.Segmentation;
import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

/**
 * <p> 结巴分词实例 </p>
 *
 * <pre> Created: 2018-04-28 11:11  </pre>
 * <pre> Project: opencc4j  </pre>
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class JiebaAnalysisSegmentation implements Segmentation {

    @Override
    public List<String> segmentate(String original) {
        return new JiebaSegmenter().sentenceProcess(original);
    }

}
