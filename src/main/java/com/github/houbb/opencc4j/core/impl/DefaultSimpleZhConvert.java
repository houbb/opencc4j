package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.impl.TSCharData;
import com.github.houbb.opencc4j.support.data.impl.TSPhaseData;
import com.github.houbb.opencc4j.support.instance.Instance;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;

import java.util.Map;

/**
 * <p> 转换为简写 </p>
 *
 * <pre> Created: 2018/6/22 下午2:47  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@ThreadSafe
public class DefaultSimpleZhConvert extends AbstractZhConvert {

    @Override
    public String toSimple(String original) {
        final Instance instance = InstanceFactory.getInstance();
        final Map<String, String> t2sPhaseMap = instance
                .singleton(TSPhaseData.class).data().getDataMap();
        final Map<String, String> t2sCharMap = instance
                .singleton(TSCharData.class).data().getDataMap();
        return super.getPhaseResult(original, t2sPhaseMap, t2sCharMap);
    }

}
