package com.github.houbb.opencc4j.core;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.1.0
 */
public class ZhConvertBootstrapTest {

    @Test
    public void toSimpleTest() {
        final String original = "生命不息，奮鬥不止";
        final String result = ZhConvertBootstrap.newInstance().toSimple(original);
        Assert.assertEquals("生命不息，奋斗不止", result);
    }

    @Test
    public void toTraditionalTest() {
        final String original = "生命不息，奋斗不止";
        final String result = ZhConvertBootstrap.newInstance().toTraditional(original);
        Assert.assertEquals("生命不息，奮鬥不止", result);
    }

    @Test
    public void segmentTest() {
        final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
        final String result = ZhConvertBootstrap.newInstance().toTraditional(original);
        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。", result);

        final String result2 = ZhConvertBootstrap.newInstance().segment(new FooSegment()).toTraditional(original);
        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result2);
    }

}
