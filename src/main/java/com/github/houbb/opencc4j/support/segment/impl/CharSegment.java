package com.github.houbb.opencc4j.support.segment.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.support.segment.Segment;

import java.util.ArrayList;
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
@ThreadSafe
public class CharSegment extends AbstractSegment {

    @Override
    protected List<String> doSeg(final String original) {
        char[] chars = original.toCharArray();
        List<String> stringList = new ArrayList<>();
        for(char c : chars) {
            stringList.add(String.valueOf(c));
        }
        return stringList;
    }

}
