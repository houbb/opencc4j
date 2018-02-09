package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.ZhConverter;
import com.github.houbb.paradise.common.util.FileUtil;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 默认中文转换
 * @author bbhou
 * @version 1.0.0
 * @since 1.0.0, 2018/02/09
 */
public class DefaultZhConverter extends AbstractZhConverter {

    private Map<String, String> charMap = new HashMap<>();
    private Map<String, String> phraseMap = new HashMap<>();


    @Override
    public ZhConverter convert() {
        return null;
    }

    private void initMap() {
        File charFile = Paths.get(config.charPath()).toFile();
        List<String> stringList = FileUtil.getFileContentEachLine(charFile);
        for(String string : stringList) {

        }
    }

}
