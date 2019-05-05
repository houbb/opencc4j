package com.github.houbb.opencc4j.support.segment;

import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import com.github.houbb.opencc4j.support.segment.impl.CharSegment;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * 字符分词测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class CharSegmentTest {

    @Test
    public void segTest() {
        final String original = "爱我中华";
        List<String> stringList = InstanceFactory.getInstance().singleton(CharSegment.class).seg(original);
        Assert.assertEquals(4, stringList.size());
    }

}
