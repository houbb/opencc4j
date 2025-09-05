package com.github.houbb.opencc4j.util;

import com.github.houbb.heaven.util.util.CollectionUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ZhSlimUtilTest {

    @Test
    public void test() {
        //項	项
        Assert.assertEquals(ZhSlimUtil.toSimple('項'), '项');
    }


    public static void main(String[] args) {
        final int times = 100000;
        String text = "大家好，我是老马。\n" +
                "\n" +
                "一直想实现一款简单好用敏感词工具，于是开源实现了这个工具。\n" +
                "\n" +
                "基于 DFA 算法实现，目前敏感词库内容收录 6W+（源文件 18W+，经过一次删减）。\n" +
                "\n" +
                "后期将进行持续优化和补充敏感词库，并进一步提升算法的性能。\n" +
                "\n" +
                "v0.24.0 开始内置支持对敏感词的分类细化，不过工作量比较大，难免存在疏漏。\n" +
                "\n" +
                "欢迎 PR 改进， github 提需求，或者加入技术交流群沟通吹牛！";

        long s = System.currentTimeMillis();
        char[] chars = text.toCharArray();
        for(int i = 0; i < times; i++) {
            for(char c : chars) {
//                ZhSlimUtil.toSimple(c); //119

                getChar(c);
            }
        }
        long cost = System.currentTimeMillis() - s;
        System.out.println(cost);
    }

    private static char getChar(char c) {
        List<String> mappingList = ZhConverterUtil.toSimple(c);
        if(CollectionUtil.isEmpty(mappingList)) {
            return c;
        }

        return mappingList.get(0).charAt(0);
    }


}
