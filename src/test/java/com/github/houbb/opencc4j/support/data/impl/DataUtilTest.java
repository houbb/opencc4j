package com.github.houbb.opencc4j.support.data.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtilTest {

    @Test
    public void basicTest() {
        Map<String, List<String>> s2t = new HashMap<String, List<String>>();
        s2t.put("出租车", Arrays.asList("計程車"));
        s2t.put("面条", Arrays.asList("麵條"));

        Map<String, List<String>> t2hk = new HashMap<String, List<String>>();
        t2hk.put("計程車", Arrays.asList("的士"));
        t2hk.put("麵條", Arrays.asList("麵條"));

        Map<String, List<String>> result = DataUtil.chains(s2t, t2hk);

        // 输出验证
        Assert.assertEquals(result.get("出租车").toString(), "[的士]");
        Assert.assertEquals(result.get("面条").toString(), "[麵條]");
    }

}
