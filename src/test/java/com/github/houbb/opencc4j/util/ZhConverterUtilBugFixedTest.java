package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * ZhConverterUtil Tester.
 *
 * @author author
 * @since 1.5.2
 */
public class ZhConverterUtilBugFixedTest {

    /**
     * 判断测试
     * Method: toSimple(original)
     * @since 1.5.2
     */
    @Test
    public void bug15Test() throws Exception {
        String simple = "宝";
        String traditional = "寶";

        Assert.assertTrue(ZhConverterUtil.isSimple(simple));
        Assert.assertFalse(ZhConverterUtil.isSimple(traditional));

        Assert.assertTrue(ZhConverterUtil.isTraditional(traditional));
        Assert.assertFalse(ZhConverterUtil.isTraditional(simple));
    }

    @Test
    public void isTheSameTest() {
        Assert.assertNotEquals("寳", "寶");
    }

    @Test
    public void bug24Test() {
        final String word = "發票";
        final String word2 = "编號";
        final String word3 = "名稱";
        final String word4 = "支付寶";
        final String word5 = "支付";
        final String word6 = "家";

        Assert.assertTrue(ZhConverterUtil.isTraditional(word));
        Assert.assertTrue(ZhConverterUtil.isTraditional(word2));
        Assert.assertTrue(ZhConverterUtil.isTraditional(word3));
        Assert.assertTrue(ZhConverterUtil.isTraditional(word4));
        Assert.assertTrue(ZhConverterUtil.isSimple(word5));
        Assert.assertTrue(ZhConverterUtil.isSimple(word6));
    }

    @Test
    public void bug20Test() {
        String text = "袖里乾坤";

        Assert.assertEquals("袖里乾坤", ZhConverterUtil.toSimple(text));
    }

}
