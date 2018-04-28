package com.github.houbb.opencc4j.util;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ZhConverterUtilThread Tester.
 * 测试多线程情况下是否存在BUG
 * @author author
 * @version 1.0
 * @since 2018-02-12 08:49:43.949
 */
public class ZhConverterUtilThreadTest {

    /**
     * Method: convertToSimple(original)
     */
    @Test
    @Ignore
    public void convertToSimpleTest() throws Exception {
    }

    /**
     * Method: convertToTraditional(original)
     */
    @Test
    @Ignore
    public void convertToTraditionalTest() throws Exception {
        ExecutorService ts = Executors.newFixedThreadPool(8);
        for (;;) {
            ts.execute(new Thread() {
                @Override
                public void run() {
                    final String randomStr = buildRandomString();
                    String result = ZhConverterUtil.convertToTraditional(randomStr);
                    System.out.println(result);
                }
            });
        }
    }

    private static synchronized String buildRandomString() {
        final String row = "壬戌之秋，七月既望，苏子与客泛舟游于赤壁之下。清风徐来，水波不兴。举酒属客，诵明月之诗，歌窈窕之章。少焉，月出于东山之上，徘徊于斗牛之间。白露横江，水光接天。纵一苇之所如，凌万顷之茫然。浩浩乎如冯虚御风，而不知其所止；飘飘乎如遗世独立，羽化而登仙。";
        int lenth = 20;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < lenth; i++) {
            stringBuilder.append(row.charAt(random.nextInt(row.length())));
        }
        return stringBuilder.toString();
    }

}
