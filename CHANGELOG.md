# release_1.0.0

基础转换功能的实现

# release_1.0.1

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| Update | 完善 README | 2018-2-25 11:15:12 | |
| Feature | 添加并发测试 | 2018-5-2 08:42:33 | |  


# release_1.0.2

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| Fixed | 修正原来包的依赖 | 2018-06-22 11:03:46 | |
| Simple | 简化实现方式 | 2018-06-22 15:27:54 | |

# release_1.0.3

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| Optimize | 移除对于 paradise 的依赖，使用 jdk1.7 重新编译发布。 | 2019-4-30 14:20:20 | |
| Remove | 移除无用的文件 | 2019-4-30 14:20:20 | |

# release_1.1.0

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| Feature | 添加自定义分词支持 | 2019-5-5 16:17:59 | |
| Optimize | 代码重构，便于后期拓展 | 2019-5-5 16:17:59 | |
| Optimize | 文件加载优化 | 2019-5-5 16:17:59 | |

# release_1.2.0

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| Optimize | 使用 heaven 公共组件代替自定义的各种组件 | 2019-11-5 18:45:52 | 便于后期拓展 |
| Remove | 移除 gen-maven-plugin | 2019-11-5 18:45:52 | 感觉不需要，移除 |
| Feature | 添加 ZhConvertBootstrap 方法 | 2019-11-5 18:45:52 | 新增特性 |

# release_1.3.0

| 类型 | 变化 | 时间 | 备注 |
|:---|:---|:---|:---|
| R | 移除 junit 依赖传递 | 2020-1-12 14:42:30 | |
| U | 更新 heaven 版本 | 2020-1-12 14:42:30 | |
| D | 废弃 ZhConverterUtil#convertToSimple(String) | 2020-1-12 14:42:30 | |
| D | 废弃 ZhConverterUtil#convertToTraditional(String) | 2020-1-12 14:42:30 | |
| D | 废弃 ZhConverterUtil#convertToSimple(String, boolean) | 2020-1-12 14:42:30 | |
| D | 废弃 ZhConverterUtil#convertToTraditional(String, boolean) | 2020-1-12 14:42:30 | |
| A | 新增 ZhConverterUtil#toSimple(String) | 2020-1-12 14:42:30 | |
| A | 新增 ZhConverterUtil#toTraditional(String) | 2020-1-12 14:42:30 | |
| O | 优化 ZhConverterUtil 获取转换实例为单例 | 2020-1-12 14:42:30 | |
