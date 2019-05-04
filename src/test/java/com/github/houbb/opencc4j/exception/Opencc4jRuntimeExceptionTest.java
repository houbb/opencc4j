package com.github.houbb.opencc4j.exception;

import org.junit.Test;

/**
 * 异常类测试
 * @author binbin.hou
 * @since 1.1.0
 */
public class Opencc4jRuntimeExceptionTest {

    @Test(expected = Opencc4jRuntimeException.class)
    public void exceptionTest() {
        throw new Opencc4jRuntimeException();
    }

}
