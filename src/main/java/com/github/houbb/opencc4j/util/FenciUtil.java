package com.github.houbb.opencc4j.util;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.Collections;
import java.util.List;

/**
 * <p> </p>
 * 使用 ThreadLocal 保证数据的准确性，同时兼顾性能
 * <pre> Created: 2018/6/22 下午1:41  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public final class FenciUtil {

    private FenciUtil(){}

    /**
     * 用于保存当前线程的信息
     */
    private static final ThreadLocal<JiebaSegmenter> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 花瓣分词
     * @param original 原始数据
     * @return 分词后的列表
     */
    public static List<String> huaban(final String original) {
        try {
            if(StringUtil.isEmpty(original)) {
                return Collections.emptyList();
            }
            JiebaSegmenter segmenter = getJiebaSegmenter();
            return segmenter.sentenceProcess(original);
        } finally {
            //对于使用技术后，一定要移除。防止内存泄漏
            THREAD_LOCAL.remove();
        }
    }

    /**
     * 使用 threadLocal 获取分词器对象
     * @return 当前线程的分词器
     */
    private static JiebaSegmenter getJiebaSegmenter() {
        JiebaSegmenter segmenter = THREAD_LOCAL.get();
        if(ObjectUtil.isNull(segmenter)) {
            segmenter = new JiebaSegmenter();
            THREAD_LOCAL.set(segmenter);
        }
        return segmenter;
    }

}
