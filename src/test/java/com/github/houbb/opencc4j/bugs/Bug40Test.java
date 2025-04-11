package com.github.houbb.opencc4j.bugs;

import com.github.houbb.opencc4j.util.ZhTwConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class Bug40Test {

    //v1.9.1 版本修正。源词库信息缺失
    @Test
    public void test() {
        String originText = "面臨";
        String simpleText = ZhTwConverterUtil.toTraditional(originText);

        // 此处兼容缺失的映射，返回本身
        Assert.assertEquals(originText, simpleText);
    }

}
