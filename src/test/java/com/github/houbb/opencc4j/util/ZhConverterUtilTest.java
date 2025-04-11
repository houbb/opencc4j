package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.core.FooSegment;
import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
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
     * 是否为中文测试
     * @since 1.8.0
     */
    @Test
    public void isChineseTest() {
        Assert.assertTrue(ZhConverterUtil.isChinese("你"));
        Assert.assertTrue(ZhConverterUtil.isChinese("你好"));
        Assert.assertTrue(ZhConverterUtil.isChinese('你'));

        Assert.assertFalse(ZhConverterUtil.isChinese("你0"));
        Assert.assertFalse(ZhConverterUtil.isChinese("10"));
        Assert.assertFalse(ZhConverterUtil.isChinese('0'));
        Assert.assertFalse(ZhConverterUtil.isChinese(""));
        Assert.assertFalse(ZhConverterUtil.isChinese(null));
    }

    /**
     * 是否包含中文
     * @since 1.8.0
     */
    @Test
    public void containsChineseTest() {
        Assert.assertTrue(ZhConverterUtil.containsChinese("你"));
        Assert.assertTrue(ZhConverterUtil.containsChinese("你好"));
        Assert.assertTrue(ZhConverterUtil.containsChinese("你0"));

        Assert.assertFalse(ZhConverterUtil.containsChinese("10"));
        Assert.assertFalse(ZhConverterUtil.containsChinese(""));
        Assert.assertFalse(ZhConverterUtil.containsChinese(null));
    }


    /**
     * 是否为简体测试
     * @since 1.4.0
     */
    @Test
    public void isSimpleTest() {
        Assert.assertTrue(ZhConverterUtil.isSimple('奋'));
        Assert.assertTrue(ZhConverterUtil.isSimple("奋"));
        Assert.assertTrue(ZhConverterUtil.isSimple("奋斗"));

        Assert.assertFalse(ZhConverterUtil.isSimple('奮'));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮"));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮鬥"));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮斗"));
        Assert.assertFalse(ZhConverterUtil.isSimple("beef"));
    }

    /**
     * 包含简体测试
     * @since 1.8.0
     */
    @Test
    public void containsSimpleTest() {
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋"));
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗"));
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗2023"));

        Assert.assertFalse(ZhConverterUtil.containsSimple("編"));
        Assert.assertFalse(ZhConverterUtil.containsSimple("編號"));
    }

    /**
     * 是否为繁体测试
     * @since 1.4.0
     */
    @Test
    public void isTraditional() {
        Assert.assertTrue(ZhConverterUtil.isTraditional('編'));
        Assert.assertTrue(ZhConverterUtil.isTraditional("編"));
        Assert.assertTrue(ZhConverterUtil.isTraditional("編號"));

        Assert.assertFalse(ZhConverterUtil.isTraditional('编'));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编"));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编号"));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编號"));
    }

    /**
     * 包含繁体测试
     * @since 1.8.0
     */
    @Test
    public void containsTraditionalTest() {
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編"));
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編號"));
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編號2023"));

        Assert.assertFalse(ZhConverterUtil.containsTraditional("号"));
        Assert.assertFalse(ZhConverterUtil.containsTraditional("编号"));
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
    public void toTraditionalTest() throws Exception {
        String original = "生命不息，奋斗不止";
        String result = ZhConverterUtil.toTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

    /**
     * 字符转为简体列表
     * @since 1.6.0
     */
    @Test
    public void charToSimpleTest() {
        Assert.assertEquals("[测]", ZhConverterUtil.toSimple('測').toString());
    }

    /**
     * 字符转为简体列表
     * @since 1.6.0
     */
    @Test
    public void charToTraditionalTest() {
        Assert.assertEquals("[幹, 乾, 干]", ZhConverterUtil.toTraditional('干').toString());
        Assert.assertEquals("[發, 髮]", ZhConverterUtil.toTraditional('发').toString());
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

        Assert.assertEquals("[生, 命, 不, 息, 奮, 鬥, 不, 止]", resultList.toString());
    }

    //---------------------------------------------------------------------------------------------

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

        final String result = ZhConvertBootstrap.newInstance()
                .segment(segment)
                .init()
                .toTraditional(original)
                ;

        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
    }

    @Test
    public void toTraditionalDocTest() {
        System.out.println(ZhConverterUtil.toTraditional("新增 IDataMap 接口，便于后期繁简体转换字典的拓展"));
    }

}
