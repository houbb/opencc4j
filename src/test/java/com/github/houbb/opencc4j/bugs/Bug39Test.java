package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug39Test {

    // 只是 梁的概率更高
    @Test
    public void test() {
        String text = ZhConverterUtil.toTraditional("梁非凡");
        Assert.assertEquals("梁非凡", text);
    }

}
