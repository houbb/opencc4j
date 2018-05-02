package com.github.houbb.opencc4j.support.segmentation;

import com.github.houbb.opencc4j.support.segmentation.impl.JiebaAnalysisSegmentation;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p> </p>
 *
 * <pre> Created: 2018-04-28 11:15  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author Administrator
 * @version 1.0
 * @since JDK 1.8
 */
public class JiebaAnalysisSegmentationTest {

    /**
     * 当多线程这样使用的时候，JiebaSegmenter 会非常的慢！
     */
    @Test
    @Ignore
    public void multiThreadTest() {
        ExecutorService ts = Executors.newFixedThreadPool(100);
        while (true) {
            ts.execute(new Thread() {
                @Override
                public void run() {
                    String[] sentences =
                            new String[]{"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。",
                                    "我不喜欢日本和服。",
                                    "雷猴回归人间。",
                                    "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作",
                                    "结果婚的和尚未结过婚的"};
                    for (String sentence : sentences) {
                        Segmentation segmentation = new JiebaAnalysisSegmentation();
                        System.out.println(segmentation.segmentate(sentence));
                    }
                }
            });
        }
    }

}
