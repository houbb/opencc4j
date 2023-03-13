package com.github.houbb.opencc4j.bs;

import com.github.houbb.opencc4j.core.FooSegment;
import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.Segments;
import org.junit.Assert;
import org.junit.Test;

/**
 * 引导类测试
 * @since 1.8.0
 */
public class ZhConvertBsTest {

    /**
     * 默认配置
     */
    @Test
    public void defaultConfigTest() {
        ZhConvertBootstrap.newInstance()
                .segment(Segments.defaults())
                .dataMap(DataMaps.defaults());
    }

    /**
     * 中国台湾地区配置
     */
    @Test
    public void zhTwConfigTest() {
        ZhConvertBootstrap.newInstance()
                .segment(Segments.defaults())
                .dataMap(DataMaps.taiwan());
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
                .toTraditional(original);

        Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
    }

}
