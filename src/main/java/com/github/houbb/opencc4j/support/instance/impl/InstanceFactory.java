package com.github.houbb.opencc4j.support.instance.impl;

import com.github.houbb.opencc4j.annotation.ThreadSafe;
import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;
import com.github.houbb.opencc4j.support.instance.Instance;
import com.github.houbb.opencc4j.util.ArgUtil;
import com.github.houbb.opencc4j.util.ObjectUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例化工厂类
 * @author binbin.hou
 * @since 1.1.0
 */
@ThreadSafe
public final class InstanceFactory implements Instance {

    private InstanceFactory(){}

    /**
     * 单例 map 对象
     * 1. key 是 class 的全称
     */
    private final Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    /**
     * 线程内的 map 对象
     */
    private ThreadLocal<Map<String, Object>> mapThreadLocal = new ThreadLocal<>();

    /**
     * 静态内部类实现单例
     */
    private static class SingletonHolder {
        private static final InstanceFactory INSTANCE_FACTORY = new InstanceFactory();
    }

    /**
     * 获取单例对象
     * @return 实例化对象
     */
    public static InstanceFactory getInstance() {
        return SingletonHolder.INSTANCE_FACTORY;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T singleton(Class<T> tClass) {
        this.notNull(tClass);

        return this.getSingleton(tClass, singletonMap);
    }

    @Override
    public <T> T threadLocal(Class<T> tClass) {
        this.notNull(tClass);

        //1. 校验 map 是否存在
        Map<String, Object> map = mapThreadLocal.get();
        if(ObjectUtil.isNull(map)) {
            map = new ConcurrentHashMap<>();
        }

        //2. 获取对象
        T instance = this.getSingleton(tClass, map);

        //3. 更新 threadLocal
        mapThreadLocal.set(map);

        return instance;
    }

    @Override
    public <T> T multiple(Class<T> tClass) {
        this.notNull(tClass);

        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Opencc4jRuntimeException(e);
        }
    }

    /**
     * 获取单例对象
     * @param tClass class 类型
     * @param instanceMap 实例化对象 map
     * @return 单例对象
     */
    @SuppressWarnings("unchecked")
    private <T> T getSingleton(final Class<T> tClass, final Map<String, Object> instanceMap) {
        this.notNull(tClass);

        final String fullClassName = tClass.getName();
        T instance = (T) instanceMap.get(fullClassName);
        if(ObjectUtil.isNull(instance)) {
            instance = this.multiple(tClass);
            instanceMap.put(fullClassName, instance);
        }
        return instance;
    }


    /**
     * 断言参数不可为 null
     * @param tClass class 信息
     */
    private void notNull(final Class tClass) {
        ArgUtil.notNull(tClass, "class");
    }

}
