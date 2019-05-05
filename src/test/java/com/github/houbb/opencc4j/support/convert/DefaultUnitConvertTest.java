package com.github.houbb.opencc4j.support.convert;

import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;
import com.github.houbb.opencc4j.support.data.impl.STCharData;
import com.github.houbb.opencc4j.support.data.impl.STPhraseData;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;
import com.github.houbb.opencc4j.support.data.impl.TSPhraseData;
import com.github.houbb.opencc4j.support.instance.Instance;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.1.0
 */
public class DefaultUnitConvertTest {

    @Test
    public void toSimpleTest() {
        final Instance instance = InstanceFactory.getInstance();
        final UnitConvert unitConvert = InstanceFactory.getInstance().singleton(DefaultUnitConvert.class);

        DefaultUnitConvertContext context = new DefaultUnitConvertContext();
        context.setUnit("奮鬥");
        context.setCharData(instance.singleton(TSCharData.class).data().getDataMap());
        context.setPhraseData(instance.singleton(TSPhraseData.class).data().getDataMap());

        Assert.assertEquals("奋斗", unitConvert.convert(context));
    }

    @Test
    public void toTraditionalTest() {
        final Instance instance = InstanceFactory.getInstance();
        final UnitConvert unitConvert = InstanceFactory.getInstance().singleton(DefaultUnitConvert.class);

        DefaultUnitConvertContext context = new DefaultUnitConvertContext();
        context.setUnit("奋斗");
        context.setCharData(instance.singleton(STCharData.class).data().getDataMap());
        context.setPhraseData(instance.singleton(STPhraseData.class).data().getDataMap());

        Assert.assertEquals("奮鬥", unitConvert.convert(context));
    }

}
