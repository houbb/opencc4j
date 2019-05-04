package com.github.houbb.opencc4j.util;

import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ArgUtilTest {

    @Test
    public void notNullOneTest() {
        ArgUtil.notNull("", "string");
    }

    @Test(expected = Opencc4jRuntimeException.class)
    public void notNullExTest() {
        ArgUtil.notNull(null, "string");
    }

}
