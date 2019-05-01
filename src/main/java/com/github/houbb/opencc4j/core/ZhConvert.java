package com.github.houbb.opencc4j.core;

/**
 * <p> 中文转换接口 </p>
 *
 * <pre> Created: 2018/6/22 下午2:42  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface ZhConvert {

    /**
     * 对中文进行转化
     * @param original 原始信息
     * @return 转换后的信息
     */
    String convert(final String original);

}
