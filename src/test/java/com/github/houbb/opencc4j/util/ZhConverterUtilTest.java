package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * ZhConverterUtil Tester.
 *
 * @author author
 * @version 1.0
 * @since 2018-02-12 08:49:43.949
 */
public class ZhConverterUtilTest {

    /**
     * 空内容测试
     * Method: convertToSimple(original)
     */
    @Test
    public void convertToSimpleEmptyTest() throws Exception {
        String original = "";
        String result = ZhConverterUtil.convertToSimple(original);
        Assert.assertEquals("", result);

        original = null;
        result = ZhConverterUtil.convertToSimple(original);
        Assert.assertEquals(null, result);
    }

    /**
     * Method: convertToSimple(original)
     */
    @Test
    public void convertToSimpleTest() throws Exception {
        String original = "生命不息，奮鬥不止";
        String result = ZhConverterUtil.convertToSimple(original);
        Assert.assertEquals("生命不息，奋斗不止", result);
    }

    /**
     * Method: convertToSimple(original)
     */
    @Test
    public void convertToSimpleOriginalTest() throws Exception {
        String original = "生命不息，奮鬥不止";
        String result = ZhConverterUtil.convertToSimple(new StringBuilder(original));
        Assert.assertEquals("生命不息，奋斗不止", result);
    }

    /**
     * Method: convertToTraditional(original)
     */
    @Test
    public void convertToTraditionalEmptyTest() throws Exception {
        String original = "";
        String result = ZhConverterUtil.convertToTraditional(original);
        Assert.assertEquals("", result);

        original = null;
        result = ZhConverterUtil.convertToTraditional(original);
        Assert.assertEquals(null, result);
    }

    /**
     * Method: convertToTraditional(original)
     */
    @Test
    public void convertToTraditionalTest() throws Exception {
        String original = "生命不息，奋斗不止";
        String result = ZhConverterUtil.convertToTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

    /**
     * Method: convertToTraditional(original)
     */
    @Test
    public void convertToTraditionalOriginalTest() throws Exception {
        StringBuilder original = new StringBuilder("生命不息，奋斗不止");
        String result = ZhConverterUtil.convertToTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }


}
