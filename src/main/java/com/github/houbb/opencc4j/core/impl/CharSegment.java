package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.Segment;
import com.github.houbb.opencc4j.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p> 简单的转化为 char 列表 </p>
 *
 * <pre> Created: 2018/6/22 下午2:43  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CharSegment implements Segment {

    @Override
    public List<String> seg(String original) {
        if(StringUtil.isEmpty(original)) {
            return Collections.emptyList();
        }

        char[] chars = original.toCharArray();
        List<String> stringList = new ArrayList<>();
        for(char c : chars) {
            stringList.add(String.valueOf(c));
        }
        return stringList;
    }

}
