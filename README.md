# Opencc4j

[Opencc4j](https://github.com/houbb/opencc4j) 支持中文繁简体转换，考虑到词组级别。

[![Build Status](https://travis-ci.com/houbb/opencc4j.svg?branch=master)](https://travis-ci.com/houbb/opencc4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/opencc4j/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/opencc4j)

> [在线体验](https://houbb.github.io/opensource/opencc4j)

## Features 特点

- 严格区分「一简对多繁」和「一简对多异」。

- 完全兼容异体字，可以实现动态替换。

- 严格审校一简对多繁词条，原则为「能分则不合」。

- 词库和函数库完全分离，可以自由修改、导入、扩展。

- 兼容 Windows、Linux、Mac 平台。

- 支持自定义分词

- 支持判断单个字（词）是否为简体/繁体

- 支持返回字符串中简体/繁体的列表信息 

- 支持中国台湾地区繁简体转换

## online 在线体验

> [http://houbb.github.io/tools/nlp.html](http://houbb.github.io/tools/nlp.html)

### v1.7.2 版本变更

- 修正繁体=》简体映射缺失的情况

> [变更日志](CHANGELOG.md)

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
    <version>1.7.2</version>
</dependency>
```

## api 概览

核心工具列表如下：

| 序号 | 工具类 | 简介 |
|:---|:---|:---|
| 1 | ZhConverterUtil | 基础的繁简体转换 |
| 2 | ZhTwConverterUtil | 台湾地区的繁简体转换 |

所有的工具类方法具有相同的方法设计，便于记忆。

核心方法如下：

| 序号 | api 方法 | 简介 |
|:---|:---|:---|
| 1 | toSimple(String) | 转为简体 |
| 2 | toTraditional(String) | 转为繁体 |
| 3 | simpleList(String) | 返回包含的简体列表 |
| 4 | traditionalList(String) | 返回包含的繁体列表 |
| 5 | isSimple(String) | 是否为简体 |
| 6 | isTraditional(String) | 是否为繁体 |
| 7 | toSimple(char) | 返回单个汉字对应的所有简体字列表 |
| 8 | toTraditional(char) | 返回单个汉字对应的所有繁体字列表 |

## 繁简体转换

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

## 句子中包含的繁简体列表返回

返回字符串中繁简体对应的词、字列表，默认支持中文分词。

繁简体列表返回的词组和分词策略紧密相关。

### 简体列表

```java
final String original = "生命不息奋斗不止";
final List<String> resultList = ZhConverterUtil.simpleList(original);

Assert.assertEquals("[生, 命, 不, 息, 奋斗, 不, 止]", resultList.toString());
```

### 繁体列表

```java
final String original = "生命不息奮鬥不止";
final List<String> resultList = ZhConverterUtil.traditionalList(original);

Assert.assertEquals("[奮, 鬥]", resultList.toString());
```

## 单个汉字对应的繁简体列表

### 繁体字列表

```java
Assert.assertEquals("[幹, 乾, 干]", ZhConverterUtil.toTraditional('干').toString());
Assert.assertEquals("[發, 髮]", ZhConverterUtil.toTraditional('发').toString());
```

### 简体字列表

```java
Assert.assertEquals("[测]", ZhConverterUtil.toSimple('測').toString());
```

# 中文分词策略

## 系统内置分词方式

你可以通过 `Segments` 工具类获取系统内置的分词实现。

| 序号 | 方法 | 准确性 | 性能 | 备注 |
|:---|:---|:---|:---|:---|
| 1 | defaults() | 高 | 高 | 默认分词形式，暂时为 `fastForward` 策略 |
| 2 | fastForward() | 较高 | 高 | fast-forward 分词策略 |
| 3 | chars() | 低 | 高 | 将字符串转换为单个字符列表，一般不建议使用 |
| 4 | huaBan() | 高 | 一般 | 花瓣的结巴分词策略 |

### 花瓣结巴分词

花瓣结巴分词在使用时，需要自行引入结巴分词依赖。

```xml
<dependency>
    <groupId>com.huaban</groupId>
    <artifactId>jieba-analysis</artifactId>
    <version>1.0.2</version>
</dependency>
```

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
final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
final Segment segment = new FooSegment();
final String result = ZhConverterUtil.toTraditional(original, segment);

Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
```

# 中国台湾繁简体转换

## 工具类

为保证方法的一致性，引入 `ZhTwConverterUtil` 工具类，支持方法和 `ZhConverterUtil` 保持一致。

## 测试用例

简体到繁体：

```java
String original = "使用互联网";
String result = ZhTwConverterUtil.toTraditional(original);
Assert.assertEquals("使用網際網路", result);
```

繁体到简体：

```java
String original = "使用網際網路";
String result = ZhTwConverterUtil.toSimple(original);
Assert.assertEquals("使用互联网", result);
```

# 技术鸣谢

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 提供的原始数据信息。

## 花瓣

[jieba-analysis](https://github.com/huaban/jieba-analysis) 提供中文分词

# Issues & Bugs

[需求和 BUG](https://github.com/houbb/opencc4j/issues) 在这里，欢迎提供宝贵的建议。

如果对您有帮助，欢迎 Star 鼓励作者。

# NLP 开源矩阵

[pinyin 汉字转拼音](https://github.com/houbb/pinyin)

[pinyin2hanzi 拼音转汉字](https://github.com/houbb/pinyin2hanzi)

[segment 高性能中文分词](https://github.com/houbb/segment)

[opencc4j 中文繁简体转换](https://github.com/houbb/opencc4j)

[nlp-hanzi-similar 汉字相似度](https://github.com/houbb/nlp-hanzi-similar)

[word-checker 拼写检测](https://github.com/houbb/word-checker)

[sensitive-word 敏感词](https://github.com/houbb/sensitive-word)

# 后期 Road-Map

- [ ] 数据字典插件化

- [ ] 考虑长文本分段，并行转换
