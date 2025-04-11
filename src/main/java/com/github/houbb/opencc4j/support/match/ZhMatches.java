package com.github.houbb.opencc4j.support.match;

import com.github.houbb.opencc4j.support.match.impl.*;

/**
 * 匹配策略
 *
 * @since 1.11.0
 */
public final class ZhMatches {

    /**
     * 满足任一简体
     * @return 实现
     */
    public static ZhMatch simpleAny() {
        return new SimpleZhMatchAny();
    }

    /**
     * 满足全部简体
     * @return 实现
     */
    public static ZhMatch simpleAll() {
        return new SimpleZhMatchAll();
    }

    /**
     * 满足超过一半简体
     * @return 实现
     */
    public static ZhMatch simpleOverHalf() {
        return new SimpleZhMatchOverHalf();
    }

    /**
     * 满足任一繁体
     * @return 实现
     */
    public static ZhMatch traditionalAny() {
        return new TraditionalZhMatchAny();
    }

    /**
     * 满足全部繁体
     * @return 实现
     */
    public static ZhMatch traditionalAll() {
        return new TraditionalZhMatchAll();
    }

    /**
     * 满足超过一半繁体
     * @return 实现
     */
    public static ZhMatch traditionalOverHalf() {
        return new TraditionalZhMatchOverHalf();
    }


}
