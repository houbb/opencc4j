package com.github.houbb.opencc4j.constant;

/**
 * 1. 用于指定本项目中常用的常量
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public final class AppConstant {

    /**    
     *  app constant    
     */    
    private AppConstant(){}

    /**
     * 默认编码
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 空白结果
     */
    public static final String EMPTY_RESULT = "\uD86D\uDDF5";

    /**    
     *  simple to traditional    
     */    
    public static final class SimpleToTraditional {

        /**
         *  traditional to simple        
         */        
        private SimpleToTraditional(){}

        /**
         * 单词
         */
        public static final String CHAR_PATH = "/data/dictionary/STCharacters.txt";
        /**
         * 短语
         */
        public static final String PHRASE_PATH = "/data/dictionary/STPhrases.txt";
    }

    /**    
     *  traditional to simple    
     */    
    public static final class TraditionalToSimple {

        /**        
         *  traditional to simple        
         */        
        private TraditionalToSimple(){}

        /**
         * 单词
         */
        public static final String CHAR_PATH = "/data/dictionary/TSCharacters.txt";
        /**
         * 短语
         */
        public static final String PHRASE_PATH = "/data/dictionary/TSPhrases.txt";
    }

}
