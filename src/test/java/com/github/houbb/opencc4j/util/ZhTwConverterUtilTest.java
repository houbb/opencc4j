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
     * 轉換台灣異體字
     * @since 1.7.0
     */
    @Test
    public void testTwVariants() throws Exception {
        String original = "为什么嘴唇裂了";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("爲什麼嘴脣裂了", result);
    }

}
