package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug34Test {

    @Test
    public void test() {
        String originText = "齾";
        String simpleText = ZhConverterUtil.toSimple(originText);

        // 此处兼容缺失的映射，返回本身
        Assert.assertEquals(originText, simpleText);
    }

}
