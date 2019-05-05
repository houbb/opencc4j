package com.github.houbb.opencc4j.support.instance;

import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import com.github.houbb.opencc4j.support.segment.impl.CharSegment;
import org.junit.Assert;
import org.junit.Test;

/**
 * 实例化工厂测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class InstanceFactoryTest {

    /**
     * 单例测试
     */
    @Test
    public void singletonTest() {
        CharSegment charSegment1 = InstanceFactory.getInstance().singleton(CharSegment.class);
        CharSegment charSegment2 = InstanceFactory.getInstance().singleton(CharSegment.class);

        Assert.assertEquals(charSegment1, charSegment2);
    }

    /**
     * 多例测试
     */
    @Test
    public void multipleTest() {
        CharSegment charSegment1 = InstanceFactory.getInstance().multiple(CharSegment.class);
        CharSegment charSegment2 = InstanceFactory.getInstance().multiple(CharSegment.class);

        Assert.assertNotEquals(charSegment1, charSegment2);
    }

}
