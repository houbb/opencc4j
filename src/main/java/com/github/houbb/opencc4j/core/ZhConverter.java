package com.github.houbb.opencc4j.core;

import com.github.houbb.opencc4j.support.config.Config;

/**
 * 中文转换接口定义
 * 1. 支持 fluent 语法
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public interface ZhConverter {

    /**
     * 设置初始值
     * @param stringBuilder 原始内容
     * @return 接口本身
     */
    ZhConverter setOriginal(StringBuilder stringBuilder);

    /**
     * 设置初始值
     * @param string 原始内容
     * @return 接口本身
     */
    ZhConverter setOriginal(String string);

    /**
     * 设置配置信息
     * @param config 配置属性
     * @return 接口本身
     */
    ZhConverter setConfig(Config config);

    /**
     * 进行转换
     * @return 接口本身
     */
    ZhConverter convert();

    /**
     * 清空设置的原始信息
     * @return 接口本身
     */
    ZhConverter clear();

    /**
     * 获取转换的结果
     * @return 结果
     */
    String getResult();



}
