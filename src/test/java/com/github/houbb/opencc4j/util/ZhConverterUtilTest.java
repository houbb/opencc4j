package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.core.FooSegment;
import com.github.houbb.opencc4j.support.segment.Segment;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
     * Method: toSimple(original)
     * @since 1.3.0
     */
    @Test
    public void toSimpleEmptyTest() throws Exception {
        String original = "";
        String result = ZhConverterUtil.toSimple(original);
        Assert.assertEquals("", result);

        original = null;
        result = ZhConverterUtil.toSimple(original);
        Assert.assertNull(result);
    }

    /**
     * Method: toSimple(original)
     * @since 1.3.0
     */
    @Test
    public void toSimpleTest() throws Exception {
        String original = "生命不息，奮鬥不止";
        String result = ZhConverterUtil.toSimple(original);
        Assert.assertEquals("生命不息，奋斗不止", result);
    }

    /**
     * Method: toTraditional(original)
     * @since 1.3.0
     */
    @Test
    public void toTraditionalEmptyTest() throws Exception {
        String original = "";
        String result = ZhConverterUtil.toTraditional(original);
        Assert.assertEquals("", result);

        original = null;
        result = ZhConverterUtil.toTraditional(original);
        Assert.assertNull(result);
    }

    /**
     * Method: toTraditional(original)
     * @since 1.3.0
     */
    @Test
    public void toTraditionalTest() throws Exception {
        String original = "生命不息，奋斗不止";
        String result = ZhConverterUtil.toTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

    /**
     * 转换测试
     * @since 1.4.0
     */
    @Test
    public void toTraditionalTest2() {
        final String text = "这是一个伸手不见五指的黑夜";
        String result = ZhConverterUtil.toTraditional(text);
        Assert.assertEquals("這是一個伸手不見五指的黑夜", result);
    }

    /**
     * 是否为简体测试
     * @since 1.4.0
     */
    @Test
    public void isSimpleTest() {
        final String simpleChar = "奋";
        final String simplePhrase = "奋斗";
        final String traditionalChar = "奮";
        final String traditionalPhrase = "奮鬥";

        Assert.assertTrue(ZhConverterUtil.isSimple(simpleChar));
        Assert.assertTrue(ZhConverterUtil.isSimple(simplePhrase));
        Assert.assertFalse(ZhConverterUtil.isSimple(traditionalChar));
        Assert.assertFalse(ZhConverterUtil.isSimple(traditionalPhrase));
    }

    /**
     * 是否为繁体测试
     * @since 1.4.0
     */
    @Test
    public void isTraditional() {
        final String simpleChar = "奋";
        final String simplePhrase = "奋斗";
        final String traditionalChar = "奮";
        final String traditionalPhrase = "奮鬥";

        Assert.assertTrue(ZhConverterUtil.isTraditional(traditionalChar));
        Assert.assertTrue(ZhConverterUtil.isTraditional(traditionalPhrase));
        Assert.assertFalse(ZhConverterUtil.isTraditional(simpleChar));
        Assert.assertFalse(ZhConverterUtil.isTraditional(simplePhrase));
    }

    /**
     * 获取简体字（词）列表
     * @since 1.4.0
     */
    @Test
    public void simpleListTest() {
        final String original = "生命不息奋斗不止";
        final List<String> resultList = ZhConverterUtil.simpleList(original);

        Assert.assertEquals("[生, 命, 不, 息, 奋斗, 不, 止]", resultList.toString());
    }

    /**
     * 获取繁体字（词）列表
     * @since 1.4.0
     */
    @Test
    public void traditionalListTest() {
        final String original = "生命不息奮鬥不止";
        final List<String> resultList = ZhConverterUtil.traditionalList(original);

        Assert.assertEquals("[奮, 鬥]", resultList.toString());
    }

    /**
     * 分词导致的问题
     * @since 0.1.5
     */
    @Test
    public void bug11Test() {
        final String t = "項鍊";
        final String s = "项链";

        Assert.assertEquals(s, ZhConverterUtil.toSimple(t));
    }

    /**
     * 自定义分词测试
     * @since 0.1.5
     */
    @Test
    public void defineSegmentTest() {
        final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
        final Segment segment = new FooSegment();
        final String result = ZhConverterUtil.toTraditional(original, segment);

        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
    }

}
