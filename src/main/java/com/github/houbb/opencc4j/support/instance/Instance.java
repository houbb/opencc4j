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
     * 注意：可能会内存泄漏的场景。
     * (1) 只要这个线程对象被gc回收，就不会出现内存泄露，但在threadLocal设为null和线程结束这段时间不会被回收的，就发生了我们认为的内存泄露。
     * 最要命的是线程对象不被回收的情况，这就发生了真正意义上的内存泄露。比如使用线程池的时候，线程结束是不会销毁的，会再次使用的。就可能出现内存泄露。　
     * 参考资料：https://www.cnblogs.com/onlywujun/p/3524675.html
     * @param tClass class 类型
     * @return 实例化对象
     * @see java.lang.ref.WeakReference 弱引用
     */
    <T> T threadLocal(final Class<T> tClass);

    /**
     * 多例对象，每次都是全新的创建
     * @param tClass class 类型
     * @return 实例化对象
     */
    <T> T multiple(final Class<T> tClass);

}
