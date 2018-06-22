package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.ZhConvert;
import com.github.houbb.opencc4j.util.DataFileUtil;

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
public class ToSimpleZhConvert implements ZhConvert {
    @Override
    public String convert(String original) {
        return DataFileUtil.getT2SResult(original);
    }
}
