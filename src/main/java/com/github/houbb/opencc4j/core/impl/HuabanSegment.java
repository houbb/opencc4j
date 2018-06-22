package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.opencc4j.core.Segment;
import com.github.houbb.opencc4j.util.FenciUtil;

import java.util.List;

/**
 * <p> 花瓣分词 </p>
 *
 * <pre> Created: 2018/6/22 下午2:43  </pre>
 * <pre> Project: opencc4j  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class HuabanSegment implements Segment {

    @Override
    public List<String> seg(String original) {
       return FenciUtil.huaban(original);
    }

}
