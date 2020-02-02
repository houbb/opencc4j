# opencc4j

[Opencc4j](https://github.com/houbb/opencc4j) 支持中文繁简体转换，考虑到词组级别。

[![Build Status](https://travis-ci.com/houbb/opencc4j.svg?branch=master)](https://travis-ci.com/houbb/opencc4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/opencc4j/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/opencc4j)

> [变更日志](CHANGELOG.md)

## Features 特點

- 嚴格區分「一簡對多繁」和「一簡對多異」。

- 完全兼容異體字，可以實現動態替換。

- 嚴格審校一簡對多繁詞條，原則爲「能分則不合」。

- 詞庫和函數庫完全分離，可以自由修改、導入、擴展。

- 兼容 Windows、Linux、Mac 平臺。

- 支持自定义分词

- 支持判断单个字（词）是否为简体/繁体

- 支持返回分词后的列表信息

- 支持返回字符串中简体/繁体的列表信息 

### 最新版本特性

- 新增工具类常用方法

## 测试代码

见 test 文件夹。

可以用来学习相关方法的使用方式。

## 创作缘由

- OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 的思想非常优秀，做的也特别棒。但是没有特别为 java 提供的工具。

- jopencc

[jopencc](https://github.com/carlostse/jopencc) 没有提供分词功能。

# 快速开始

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>opencc4j</artifactId>
    <version>1.4.0</version>
</dependency>
```

## 繁简体转换

对字符串进行繁简体转换，默认支持中文分词。

### 转为简体

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.toSimple(original);
Assert.assertEquals("生命不息，奋斗不止", result);
```

### 转为繁体

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.toTraditional(original);
Assert.assertEquals("生命不息，奮鬥不止", result);
```

## 繁简体判断

对单个字符或者词组进行繁简体判断。

### 是否为简体

```java
final String simpleChar = "奋";
final String simplePhrase = "奋斗";
final String traditionalChar = "奮";
final String traditionalPhrase = "奮鬥";

Assert.assertTrue(ZhConverterUtil.isSimple(simpleChar));
Assert.assertTrue(ZhConverterUtil.isSimple(simplePhrase));
Assert.assertFalse(ZhConverterUtil.isSimple(traditionalChar));
Assert.assertFalse(ZhConverterUtil.isSimple(traditionalPhrase));
```

### 是否为繁体

```java
final String simpleChar = "奋";
final String simplePhrase = "奋斗";
final String traditionalChar = "奮";
final String traditionalPhrase = "奮鬥";

Assert.assertTrue(ZhConverterUtil.isTraditional(traditionalChar));
Assert.assertTrue(ZhConverterUtil.isTraditional(traditionalPhrase));
Assert.assertFalse(ZhConverterUtil.isTraditional(simpleChar));
Assert.assertFalse(ZhConverterUtil.isTraditional(simplePhrase));
```

## 繁简体列表返回

返回字符串中繁简体对应的词、字列表，默认支持中文分词。

### 简体列表

```java
final String original = "生命不息奋斗不止";
final List<String> resultList = ZhConverterUtil.simpleList(original);

Assert.assertEquals("[生命不息, 奋斗, 不止]", resultList.toString());
```

### 繁体列表

```java
final String original = "生命不息奮鬥不止";
final List<String> resultList = ZhConverterUtil.traditionalList(original);

Assert.assertEquals("[奮鬥]", resultList.toString());
```

# 引导类方式

## 为什么需要引导类

v1.1.0 之后引入了类 [ZhConvertBootstrap](https://github.com/houbb/opencc4j/blob/master/src/main/java/com/github/houbb/opencc4j/core/impl/ZhConvertBootstrap.java) 可以提供更加灵活的功能，支持 fluent 语法。

### 对比静态方法的优势

工具类的静态方法使用起来很方便，但是不是很利于拓展变化。

后期想添加更多的方法，就会发现静态方法开始有些不够优雅，方法数量也会变得较多。所以自定义分词没有暴露静态方法，

建议用户根据 ZhConvertBootstrap 灵活创建属于自己的工具类。

## 引导类使用

和工具类保持相同的 api，降低学习成本。

此处演示其中一个功能。

### 转为简体

```java
final String original = "生命不息，奮鬥不止";
final String result = ZhConvertBootstrap.newInstance().toSimple(original);
Assert.assertEquals("生命不息，奋斗不止", result);
```
# 自定义分词方式

## 系统内置分词方式

你可以通过 `Segments` 工具类获取系统内置的分词实现。

| 序号 | 方法 | 准确性 | 性能 | 备注 |
|:---|:---|:---|:---|:---|
| 1 | defaults() | 高 | 一般 | 默认分词形式，暂时为结巴分词。 |
| 2 | chars() | 低 | 高 | 将字符串转换为单个字符列表，一般不建议使用。 |

## 自定义

你有时候可能除了上述的两种分词方式，会有更加适合自己业务的分词实现。

Opencc4j 支持自定义分词实现，只需要实现分词接口 [Segment](https://github.com/houbb/opencc4j/blob/master/src/main/java/com/github/houbb/opencc4j/support/segment/Segment.java)

- 接口内容

```java
public interface Segment {

    /**
     * 分词
     * @param original 原始信息
     * @return 分词后的列表
     */
    List<String> seg(final String original);

}
```

## 测试代码

### 自定义分词实现类

```java
/**
 * 一个最简单的分词实现。
 * 注意：仅仅做演示，不可实际使用。
 * @author binbin.hou
 * @since 1.1.0
 */
public class FooSegment implements Segment {
    @Override
    public List<String> seg(String original) {
        return Arrays.asList(original, "测试");
    }
}
```

### 分词测试

我们自定义的分词，直接在默认添加“测试”这样的信息。

```java
final String result2 = ZhConvertBootstrap.newInstance().segment(new FooSegment()).toTraditional(original);
Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result2);
```

# 技术鸣谢

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 提供的原始数据信息。

## 花瓣

[jieba-analysis](https://github.com/huaban/jieba-analysis) 提供中文分词

# Issues & Bugs

[需求和 BUG](https://github.com/houbb/opencc4j/issues) 在这里，欢迎提供宝贵的建议。

如果对您有帮助，欢迎 Star 鼓励作者。