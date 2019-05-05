package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

/**
 * <p> 花瓣分词 </p>
 *
 * <pre> Created: 2018/6/22 下午2:43  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@ThreadSafe
public class HuaBanSegment extends AbstractSegment {

    @Override
    protected List<String> doSeg(String original) {
        //线程安全：https://github.com/huaban/jieba-analysis/issues/65
        JiebaSegmenter segmenter = InstanceFactory.getInstance().singleton(JiebaSegmenter.class);
        return segmenter.sentenceProcess(original);
    }

}
