package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 中国台湾繁简体转换工具类测试
 *
 * @author jackychu0830
 * @author binbin.hou
 * @since 1.7.0
 */
public class ZhTwConverterUtilTest {


    /**
     * 轉換台灣正體 IT 用詞
     * @since 1.7.0
     */
    @Test
    public void testTwIt() throws Exception {
        String original = "使用互联网";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("使用網際網路", result);
    }

    /**
     * 台灣正體==>简体 IT 用詞
     * @since 1.7.1
     */
    @Test
    public void testTwItSimple() throws Exception {
        String original = "使用網際網路";
        String result = ZhTwConverterUtil.toSimple(original);
        Assert.assertEquals("使用互联网", result);
    }

    /**
     * 轉換台灣正體地名用詞
     * @since 1.7.0
     */
    @Test
    public void testTwName() throws Exception {
        String original = "马尔代夫是个渡胜地";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("馬爾地夫是個渡勝地", result);
    }

    /**
     * 台灣正體==》简体地名用詞
     * @since 1.7.1
     */
    @Test
    public void testTwNameSimple() throws Exception {
        String original = "馬爾地夫是個渡勝地";
        String result = ZhTwConverterUtil.toSimple(original);
        Assert.assertEquals("马尔代夫是个渡胜地", result);
    }

    /**
     * 轉換台灣正體慣用詞
     * @since 1.7.0
     */
    @Test
    public void testTwOther() throws Exception {
        String original = "骑自行车是个很棒的休闲运动";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("騎腳踏車是個很棒的休閒運動", result);
    }

    /**
     * 台灣正體==>简体慣用詞
     * @since 1.7.1
     */
    @Test
    public void testTwOtherSimple() throws Exception {
        String original = "騎腳踏車是個很棒的休閒運動";
        String result = ZhTwConverterUtil.toSimple(original);
        Assert.assertEquals("骑自行车是个很棒的休闲运动", result);
    }

    /**
     * 轉換台灣異體字
     * @since 1.7.0
     */
    @Test
    public void testTwVariants() throws Exception {
        String original = "为什么嘴唇裂了";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("為什麼嘴唇裂了", result);
    }

    /**
     * 轉換台灣異體字
     * @since 1.7.1
     */
    @Test
    public void testTwVariantsSimple() throws Exception {
        String original = "為什麼嘴唇裂了";
        String result = ZhTwConverterUtil.toSimple(original);
        Assert.assertEquals("为什么嘴唇裂了", result);
    }

    /**
     * 错误原因：基础的繁简体转换中这是一个词，导致优先级比台湾地区的转换优先级更高，所以转换失败。
     * @since 1.7.1
     */
    @Test
    public void testTwPhrase() {
        String original = "里面";
        Assert.assertEquals("裡面", ZhTwConverterUtil.toTraditional(original));

        String original2 = "硅谷";
        Assert.assertEquals("硅谷", ZhConverterUtil.toTraditional(original2));
        Assert.assertEquals("矽谷", ZhTwConverterUtil.toTraditional(original2));

        String original3 = "硅胶";
        Assert.assertEquals("矽膠", ZhTwConverterUtil.toTraditional(original3));
    }

}
