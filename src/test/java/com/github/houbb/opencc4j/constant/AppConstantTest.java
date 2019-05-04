package com.github.houbb.opencc4j.constant;

import org.junit.Assert;
import org.junit.Test;

/**
 * 常量测试类
 *
 * @author binbin.hou
 * @since 1.1.0
 */
public class AppConstantTest {

    @Test
    public void constantTest() {
        Assert.assertEquals("UTF-8", AppConstant.DEFAULT_CHARSET);
        Assert.assertEquals("\uD86D\uDDF5", AppConstant.EMPTY_RESULT);
    }

}
