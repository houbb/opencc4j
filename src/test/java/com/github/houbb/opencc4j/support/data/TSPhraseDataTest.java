package com.github.houbb.opencc4j.support.data;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.model.data.DataInfo;
import com.github.houbb.opencc4j.support.data.impl.TSPhraseData;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TSPhraseDataTest {

    @Test
    public void singletonTest() {
        DataInfo dataInfo = Instances.singleton(TSPhraseData.class).data();
        Assert.assertEquals(273, dataInfo.getDataMap().size());
    }

}
