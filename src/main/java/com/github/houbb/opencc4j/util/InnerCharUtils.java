package com.github.houbb.opencc4j.util;

import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符工具
 * @since 1.9.1
 */
public class InnerCharUtils {

    /**
     * 解决中文少数汉字，一个字占用两个字符的问题
     *
     * https://github.com/houbb/opencc4j/issues/43
     * https://github.com/houbb/opencc4j/issues/48
     *
     * @param input 输入
     * @return 结果
     * @since 1.9.1
     */
    public static List<String> toCharList(String input) {
        if(StringUtil.isEmpty(input)) {
            return Collections.emptyList();
        }

        List<String> characters = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; ) {
            char high = input.charAt(i);
            if (Character.isHighSurrogate(high) && i + 1 < length) {
                char low = input.charAt(i + 1);
                if (Character.isLowSurrogate(low)) {
                    characters.add(new String(new char[]{high, low}));
                    i += 2;
                    continue;
                }
            }
            characters.add(Character.toString(high));
            i += 1;
        }
        return characters;
    }

    /**
     * 兼容异体字
     * @param s 字符
     * @return 结果
     */
    public static boolean isChineseForSingle(final String s) {
        if (s == null || s.isEmpty() || s.length() > 2) {
            return false; // 非空且长度不超过2
        }

        // 获取字符串的码点（支持代理对）
        int codePoint = s.codePointAt(0);

        // 检查字符串长度是否与码点所需字符数匹配
        if (s.length() != Character.charCount(codePoint)) {
            return false; // 非法代理对或长度不匹配
        }

        // 扩展中文判断范围（按需调整）
        return (codePoint >= 0x4E00 && codePoint <= 0x9FFF) ||   // 基本汉字
                (codePoint >= 0x3400 && codePoint <= 0x4DBF) ||   // 扩展A
                (codePoint >= 0x20000 && codePoint <= 0x2A6DF);    // 扩展B（示例）
    }

}
