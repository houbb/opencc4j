package com.github.houbb.opencc4j.support.data;

import com.github.houbb.opencc4j.model.data.DataInfo;

/**
 * 中文数据接口
 * 1. 为了保证数据加载一次，保证使用单例使用 data 实例类。
 * 2. 对比原来，将一起加载的文件，拆分成具体的每一个文件。尽可能提升性能。
 * @author binbin.hou
 * @since 1.1.0
 */
public interface Data {

    /**
     * 构建数据信息
     * @return 数据信息
     */
    DataInfo data();

}
