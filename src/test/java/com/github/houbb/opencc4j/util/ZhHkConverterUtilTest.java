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
     * 大陆简体==>香港正體
     * @since 1.12.0
     */
    @Test
    public void testHkTraditional() {
        String original = "千家万户瞳瞳日 总把新桃换旧符";
        String result = ZhHkConverterUtil.toTraditional(original);
        Assert.assertEquals("千家萬户瞳瞳日 總把新桃換舊符", result);
    }

    /**
     * 香港正體==>大陆简体
     */
    @Test
    public void testHkSimple() {
        String original = "千家萬户瞳瞳日 總把新桃換舊符";
        String result = ZhHkConverterUtil.toSimple(original);
        Assert.assertEquals("千家万户瞳瞳日 总把新桃换旧符", result);
    }

}
