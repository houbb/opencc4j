package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug54Test {

    /**
     *【𨦟】【𪡃】
     *
     * https://github.com/houbb/opencc4j/issues/54
     */
    @Test
    public void test() {
        Assert.assertEquals("支援", ZhConverterUtil.toSimple("支援"));
        Assert.assertEquals("支援", ZhConverterUtil.toTraditional("支援"));
    }

}
