package com.github.houbb.opencc4j.model.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * 对象测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class DataInfoTest {

    @Test
    public void buildTest() {
        DataInfo dataInfo = new DataInfo();
        dataInfo.setName("data");
        dataInfo.setDataMap(null);

        Assert.assertEquals("data", dataInfo.getName());
        Assert.assertNull(dataInfo.getDataMap());
    }

}
