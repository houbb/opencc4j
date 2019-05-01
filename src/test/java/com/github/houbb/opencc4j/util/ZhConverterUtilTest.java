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
        Assert.assertNull(result);
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
     * 使用简单的单词分开
     * Method: convertToSimple(original)
     */
    @Test
    public void convertToSimpleCharsTest() throws Exception {
        String original = "生命不息，奮鬥不止";
        String result = ZhConverterUtil.convertToSimple(original, false);
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
        Assert.assertNull(result);
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
    public void convertToTraditionalCharsTest() throws Exception {
        String original = "生命不息，奋斗不止";
        String result = ZhConverterUtil.convertToTraditional(original, false);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

}
