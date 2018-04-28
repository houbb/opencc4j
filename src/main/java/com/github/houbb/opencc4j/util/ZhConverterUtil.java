package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.constant.AppConstant;
import com.github.houbb.opencc4j.core.ZhConverter;
import com.github.houbb.opencc4j.core.impl.DefaultZhConverter;
import com.github.houbb.opencc4j.support.config.Config;
import com.github.houbb.opencc4j.support.config.DefaultConfig;

/**
 * 中文转换工具类
 * (1) 编码问题
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public final class ZhConverterUtil {

    /**    
     * zh converter    
     */    
//    private static final ZhConverter zhConverter = new DefaultZhConverter();

    /**    
     *  zh converter util    
     */    
    private ZhConverterUtil(){}

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToSimple(String original) {
        Config config = new DefaultConfig(AppConstant.TraditionalToSimple.CHAR_PATH,
                AppConstant.TraditionalToSimple.PHRASE_PATH);
        ZhConverter zhConverter = new DefaultZhConverter();
        return zhConverter
                .setOriginal(original)
                .setConfig(config)
                .convert()
                .getResult();
    }

    /**
     * 转换为简体
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToSimple(StringBuilder original){
        return convertToSimple(new String(original));
    }

    /**
     * 转换为繁体
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToTraditional(String original){
        Config config = new DefaultConfig(AppConstant.SimpleToTraditional.CHAR_PATH,
                AppConstant.SimpleToTraditional.PHRASE_PATH);
        ZhConverter zhConverter = new DefaultZhConverter();
        return zhConverter.setOriginal(original).setConfig(config).convert().getResult();
    }

    /**
     * 转换为繁体
     * @param original 原始内容
     * @return 转换后的内容
     */
    public static String convertToTraditional(StringBuilder original){
        return convertToTraditional(new String(original));
    }

}
