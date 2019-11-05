package com.github.houbb.opencc4j.support.convert;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;
import com.github.houbb.opencc4j.support.data.impl.STCharData;
import com.github.houbb.opencc4j.support.data.impl.STPhraseData;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;
import com.github.houbb.opencc4j.support.data.impl.TSPhraseData;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.1.0
 */
public class DefaultUnitConvertTest {

    @Test
    public void toSimpleTest() {
        final UnitConvert unitConvert = Instances.singleton(DefaultUnitConvert.class);

        DefaultUnitConvertContext context = new DefaultUnitConvertContext();
        context.setUnit("奮鬥");
        context.setCharData(Instances.singleton(TSCharData.class).data().getDataMap());
        context.setPhraseData(Instances.singleton(TSPhraseData.class).data().getDataMap());

        Assert.assertEquals("奋斗", unitConvert.convert(context));
    }

    @Test
    public void toTraditionalTest() {
        final UnitConvert unitConvert = Instances.singleton(DefaultUnitConvert.class);

        DefaultUnitConvertContext context = new DefaultUnitConvertContext();
        context.setUnit("奋斗");
        context.setCharData(Instances.singleton(STCharData.class).data().getDataMap());
        context.setPhraseData(Instances.singleton(STPhraseData.class).data().getDataMap());

        Assert.assertEquals("奮鬥", unitConvert.convert(context));
    }

}
