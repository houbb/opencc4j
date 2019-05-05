package com.github.houbb.opencc4j.support.segment;

import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import com.github.houbb.opencc4j.support.segment.impl.HuaBanSegment;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * 字符分词测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class HuaBanSegmentTest {

    @Test
    public void segTest() {
        final String original = "爱我中华";
        List<String> stringList = InstanceFactory.getInstance().singleton(HuaBanSegment.class).seg(original);
        Assert.assertEquals(3, stringList.size());

        //[爱, 我, 中华文化]
        final String original2 = "爱我中华文化";
        List<String> stringList2 = InstanceFactory.getInstance().singleton(HuaBanSegment.class).seg(original2);
        System.out.println(stringList2);
        Assert.assertEquals(3, stringList2.size());
    }

}
