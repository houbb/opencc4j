package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import com.github.houbb.opencc4j.util.ZhTwConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug43Test {

    //v1.9.1 版本修正。源词库信息缺失

    /**
     *【𨦟】【𪡃】
     *
     * v1.9.1 版本修正，兼容双字符
     */
    @Test
    public void test() {
        String originText = "\uD862\uDD9F";
        Assert.assertEquals(true, ZhConverterUtil.isChinese(originText));

        // 此处兼容缺失的映射，返回本身
        String text = "\uD86A\uDC43还有\uD862\uDD9F";

        Assert.assertEquals("\uD86A\uDC43还有\uD862\uDD9F", ZhConverterUtil.toSimple(text));
        Assert.assertEquals("\uD86A\uDC43還有\uD862\uDD9F", ZhConverterUtil.toTraditional(text));
    }

}
