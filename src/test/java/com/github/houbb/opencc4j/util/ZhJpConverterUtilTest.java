package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 中文简体===》日文
 *
 * @author binbin.hou
 * @since 1.13.0
 */
public class ZhJpConverterUtilTest {

    /**
     * 大陆简体==>标准繁体=》日文
     */
    @Test
    public void testJpTraditional() {
        String original = "我在日本学习音乐，并学习了龙的字。";
        String result = ZhJpConverterUtil.toTraditional(original);
        Assert.assertEquals("我在日本学習音楽，並学習了竜的字。", result);
    }

    /**
     * 日文=>标准繁体=>简体
     */
    @Test
    public void testJpSimple() {
        String original = "我在日本学習音楽，並学習了竜的字。";
        String result = ZhJpConverterUtil.toSimple(original);
        Assert.assertEquals("我在日本学习音乐，并学习了龙的字。", result);
    }

}
