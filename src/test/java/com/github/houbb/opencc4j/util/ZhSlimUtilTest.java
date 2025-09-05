package com.github.houbb.opencc4j.util;

import org.junit.Assert;
import org.junit.Test;

public class ZhSlimUtilTest {

    @Test
    public void test() {
        //項	项
        Assert.assertEquals(ZhSlimUtil.toSimple('項'), '项');
    }

}
