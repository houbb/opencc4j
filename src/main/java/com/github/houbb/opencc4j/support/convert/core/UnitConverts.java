package com.github.houbb.opencc4j.support.convert.core;


import com.github.houbb.opencc4j.support.convert.core.impl.DefaultUnitConvert;

/**
 * <p> 中文单个单词/词组转换接口 </p>
 *
 * @author houbinbin
 * @since 1.10.0
 */
public class UnitConverts {

    /**
     * 默认实现
     * @return 实现
     */
    public static UnitConvert defaults() {
        return new DefaultUnitConvert();
    }

}
