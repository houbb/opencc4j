package com.github.houbb.opencc4j.data;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class TsDataTest {

    public static void main(String[] args) {
        String p = "D:\\github\\opencc4j\\src\\main\\resources\\data\\dictionary\\TSCharacters.txt";

        List<String> lines = FileUtil.readAllLines(p);
        List<String> firstLine = new ArrayList<>();
        List<String> secLine = new ArrayList<>();
        for(String line : lines) {
            String[] splits = StringUtil.splitByAnyBlank(line);
            if(splits[0].equals(splits[1])) {
                continue;
            }
            firstLine.add(splits[0]);
            secLine.add(splits[1]);
        }

        System.out.println(firstLine.size());
        System.out.println(StringUtil.join(firstLine,""));
        System.out.println(StringUtil.join(secLine,""));
    }
}
