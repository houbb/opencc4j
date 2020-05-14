package com.github.houbb.opencc4j.util;

import org.junit.Assert;
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

}
