package com.github.houbb.opencc4j.data;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class DataTwTest {

    @Test
    @Ignore
    public void toSimpleTest() {
        List<String> lines = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\test\\resources\\data\\TWPhrases_bak.txt");
        List<String> newLines = new ArrayList<>();

        for(String line : lines) {
            String[] strings = line.split(" ");
            String first = ZhConverterUtil.toSimple(strings[0]);
            String newLine = first + " " + strings[1];
            newLines.add(newLine);
        }

        FileUtil.write("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\TWPhrases.txt",
                newLines);
    }

    @Test
    public void toSimpleVarTest() {
        List<String> lines = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\test\\resources\\data\\TWVariants_bak.txt");
        List<String> newLines = new ArrayList<>();

        for(String line : lines) {
            String[] strings = line.split(" ");
            String first = ZhConverterUtil.toSimple(strings[0]);
            String newLine = first + " " + strings[1];
            newLines.add(newLine);
        }

        FileUtil.write("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\TWVariants.txt",
                newLines);
    }

}
