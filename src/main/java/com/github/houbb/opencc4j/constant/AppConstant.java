package com.github.houbb.opencc4j.constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppConstant {

    private AppConstant(){}

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static class SimpleToTraditional {
        /**
         * 单词
         */
        public static final String CHAR_PATH = "data/dictionary/STCharacters.txt";
        /**
         * 短语
         */
        public static final String PHRASE_PATH = "data/dictionary/STPhrases.txt";
    }

    public static class TraditionalToSimple {
        /**
         * 单词
         */
        public static final String CHAR_PATH = "data/dictionary/TSCharacters.txt";
        /**
         * 短语
         */
        public static final String PHRASE_PATH = "data/dictionary/TSPhrases.txt";
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(SimpleToTraditional.CHAR_PATH);
//        System.out.println(Files);
        System.out.println(path.toAbsolutePath().toFile());
    }

}
