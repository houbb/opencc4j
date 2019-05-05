package com.github.houbb.opencc4j.support.data;

import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.STPhraseData;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class STPhraseDataTest {

    @Test
    public void singletonTest() {
        DataInfo dataInfo = InstanceFactory.getInstance().singleton(STPhraseData.class).data();
        Assert.assertEquals(48933, dataInfo.getDataMap().size());
    }


}
