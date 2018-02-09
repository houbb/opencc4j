package com.github.houbb.opencc4j.core;

import com.github.houbb.opencc4j.support.config.Config;

/**
 * 中文转换接口定义
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public interface ZhConverter {

    /**
     * 设置初始值
     * @param stringBuffer
     * @return
     */
    ZhConverter setOriginal(StringBuffer stringBuffer);

    /**
     * 设置初始值
     * @param string
     * @return
     */
    ZhConverter setOriginal(String string);

    /**
     * 设置配置信息
     * @param config 配置属性
     * @return
     */
    ZhConverter setConfig(Config config);

    /**
     * 进行转换
     * @return
     */
    ZhConverter convert();

    /**
     * 清空设置的原始信息
     * @return
     */
    ZhConverter clear();

    /**
     * 获取转换的结果
     * @return
     */
    String getResult();



}
