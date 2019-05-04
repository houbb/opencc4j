package com.github.houbb.opencc4j.support.instance;

/**
 * 实例化对象的接口
 * 1. 使用此类的 class 必须有无参构造器
 * 2. 当前类出于测试阶段。
 * @author binbin.hou
 * @since 1.1.0
 */
public interface Instance {

    /**
     * 获取对象的单例对象
     * 1. 需要保证对象的线程安全性。
     * @param tClass class 类型
     * @return 实例化对象
     */
    <T> T singleton(final Class<T> tClass);

    /**
     * 获取每个线程内唯一的实例化对象
     * @param tClass class 类型
     * @return 实例化对象
     */
    <T> T threadLocal(final Class<T> tClass);

    /**
     * 清空当前线程信息
     * ps: 在线程池的场景下，重复创建会导致内存占中比较大。最后执行完，可以手动执行。
     * 当然，个人的理解是 ThreadLocal 基于弱引用，即使不清理也问题不大。
     * TODO: 此处存疑，后续验证。
     */
    void threadLocalClear();

    /**
     * 多例对象，每次都是全新的创建
     * @param tClass class 类型
     * @return 实例化对象
     */
    <T> T multiple(final Class<T> tClass);

}
