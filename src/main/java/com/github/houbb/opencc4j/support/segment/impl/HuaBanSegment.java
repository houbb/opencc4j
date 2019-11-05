package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.instance.impl.Instances;
import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

/**
 * <p> 花瓣分词 </p>
 *
 * <pre> Created: 2018/6/22 下午2:43  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.1.0
 * @since 1.1.0
 */
@ThreadSafe
public class HuaBanSegment extends AbstractSegment {

    @Override
    protected List<String> doSeg(String original) {
        //线程安全：https://github.com/huaban/jieba-analysis/issues/65
        JiebaSegmenter segmenter = Instances.singleton(JiebaSegmenter.class);
        return segmenter.sentenceProcess(original);
    }

}
