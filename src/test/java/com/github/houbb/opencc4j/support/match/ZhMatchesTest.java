package com.github.houbb.opencc4j.support.match;

import com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap;
import org.junit.Assert;
import org.junit.Test;

public class ZhMatchesTest {

    @Test
    public void isSimpleTest() {
        // 全部
        ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
                .isSimpleMatch(ZhMatches.simpleAll())
                .init();
        String text = "123我456";
        Assert.assertFalse(bs.isSimple(text));

        // 任一
        bs.isSimpleMatch(ZhMatches.simpleAny()).init();
        Assert.assertTrue(bs.isSimple(text));
    }

    @Test
    public void isTraditionalTest() {
        // 全部
        ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
                .isTraditionalMatch(ZhMatches.traditionalAll())
                .init();
        String text = "123俺們456";
        Assert.assertFalse(bs.isTraditional(text));

        // 任一
        bs.isTraditionalMatch(ZhMatches.traditionalAny()).init();
        Assert.assertTrue(bs.isTraditional(text));;
    }

}
