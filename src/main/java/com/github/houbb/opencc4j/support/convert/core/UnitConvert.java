package com.github.houbb.opencc4j.support.convert.core;


import com.github.houbb.opencc4j.support.convert.context.UnitConvertContext;

/**
 * <p> 中文单个单词/词组转换接口 </p>
 *
 * <pre> Created: 2018/6/22 下午2:42  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.1.0
 * @since 1.1.0
 */
public interface UnitConvert {

    /**
     * 中文单元转化类
     * @param context 上下文
     * @return 转换结果
     */
    String convert(final UnitConvertContext context);

}
