package com.github.houbb.opencc4j.bs;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import com.github.houbb.opencc4j.data.MyFooDataMapExtra;
import com.github.houbb.opencc4j.data.MyFooDataMapExtra2;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.support.segment.impl.DataMapFastForwardSegment;
import org.junit.Assert;
import org.junit.Test;

/**
 * 引导类测试
 * @since 1.8.0
 */
public class ZhConvertBsMyDataMapTest {

    /**
     * 默认配置
     */
    @Test
    public void defaultConfigTest() {
        // 1.1自定义的额外数据集
        final IDataMap dataMap = new MyFooDataMapExtra();
        // 1.2 指定分词策略
        final Segment segment = new DataMapFastForwardSegment(dataMap);

        // 2. 指定
        ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
                .dataMap(dataMap)
                .segment(segment)
                .init()
                ;

        // 3. 使用
        Assert.assertEquals(bs.toTraditional("人生自是有情痴,此恨不关风月"), "人生自是有情癡,此恨不關風玥");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
    }

    /**
     * 默认配置
     */
    @Test
    public void defaultConfigTest2() {
        // 1.1自定义的额外数据集
        final IDataMap dataMap = new MyFooDataMapExtra();
        // 1.2 指定分词策略
        final Segment segment = new DataMapFastForwardSegment(dataMap);

        // 2. 指定
        ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
                .dataMap(dataMap)
                .segment(segment)
                .init()
                ;

        // 3. 使用
        Assert.assertEquals(bs.toTraditional("人生自是有情痴,此恨不关风月"), "人生自是有情癡,此恨不關風玥");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");


        // 1.1自定义的额外数据集
        final IDataMap dataMap2 = new MyFooDataMapExtra2();
        // 1.2 指定分词策略
        final Segment segment2 = new DataMapFastForwardSegment(dataMap2);

        // 2. 指定
        ZhConvertBootstrap bs2 = ZhConvertBootstrap.newInstance()
                .dataMap(dataMap2)
                .segment(segment2)
                .init()
                ;

        // 3. 使用
        Assert.assertEquals(bs2.toTraditional("人生自是有情痴,此恨不关风月"), "人生自是有情癡,此恨不關風玥2");
        Assert.assertEquals(bs2.toSimple("人生自是有情癡,此恨不關風玥2"), "人生自是有情痴,此恨不关风月22");
    }

    /**
     * 默认配置
     */
    @Test
    public void timesTest() {
        // 1.1自定义的额外数据集
        final IDataMap dataMap = new MyFooDataMapExtra();
        // 1.2 指定分词策略
        final Segment segment = new DataMapFastForwardSegment(dataMap);

        // 2. 指定
        ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
                .dataMap(dataMap)
                .segment(segment)
                .init()
                ;

        // 3. 使用
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
    }

}
