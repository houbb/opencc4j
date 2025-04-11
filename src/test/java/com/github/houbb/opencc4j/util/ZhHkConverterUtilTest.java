package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 中国香港繁简体转换工具类测试
 *
 * @author binbin.hou
 * @since 1.12.0
 */
public class ZhHkConverterUtilTest {


    /**
     * 轉換香港正體 IT 用詞
     * @since 1.12.0
     */
    @Test
    public void testHkIt() throws Exception {
        String original = "他坐出租车去超市买了方便面和卫生纸";
        String result = ZhHkConverterUtil.toTraditional(original);
        Assert.assertEquals("他坐出租車去超市買了方便麪和衞生紙", result);
    }

    /**
     * 香港正體==>简体 IT 用詞
     */
    @Test
    public void testHkItSimple() throws Exception {
        String original = "他坐出租車去超市買了方便麪和衞生紙";
        String result = ZhHkConverterUtil.toSimple(original);
        // TODO... 没转换回来？？
        Assert.assertEquals("他坐出租车去超市买了方便面和衞生纸", result);
    }

}
