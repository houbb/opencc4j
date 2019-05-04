package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.data.impl.S2TCharData;
import com.github.houbb.opencc4j.support.data.impl.S2TPhaseData;
import com.github.houbb.opencc4j.support.instance.Instance;
import com.github.houbb.opencc4j.support.instance.impl.InstanceFactory;

import java.util.Map;

/**
 * <p> 转换为繁体 </p>
 *
 * <pre> Created: 2018/6/22 下午2:47  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @since 1.1.0
 */
@ThreadSafe
public class DefaultTraditionalZhConvert extends AbstractZhConvert {

    @Override
    public String toTraditional(String original) {
        final Instance instance = InstanceFactory.getInstance();
        final Map<String, String> s2tPhaseMap = instance
                .singleton(S2TPhaseData.class).data().getDataMap();
        final Map<String, String> s2tCharMap = instance
                .singleton(S2TCharData.class).data().getDataMap();
        return super.getPhaseResult(original, s2tPhaseMap, s2tCharMap);
    }

}
