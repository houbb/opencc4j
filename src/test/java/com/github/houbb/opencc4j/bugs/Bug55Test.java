package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug55Test {

    /**
     * https://github.com/houbb/opencc4j/issues/55
     */
    @Test
    public void test() {
        Assert.assertEquals("審核", ZhConverterUtil.toTraditional("审核"));
    }

}
