# opencc4j

Opencc4j 支持中文繁简体转换，考虑到词组级别。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Build Status](https://www.travis-ci.org/houbb/opencc4j.svg?branch=master)](https://www.travis-ci.org/houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)

> [English Readme](README-ENGLISH.md)

## Features 特點

- 嚴格區分「一簡對多繁」和「一簡對多異」。

- 完全兼容異體字，可以實現動態替換。

- 嚴格審校一簡對多繁詞條，原則爲「能分則不合」。

- 詞庫和函數庫完全分離，可以自由修改、導入、擴展。

- 兼容 Windows、Linux、Mac 平臺。


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
    <version>1.0.1</version>
</dependency>
```

PS: 此处还需要额外引入2个依赖， release_1.0.2 将默认依赖。

```xml
<dependencies>
        <dependency>
            <groupId>com.github.houbb</groupId>
            <artifactId>paradise-common</artifactId>
            <version>1.1.3</version>
        </dependency>
        <dependency>
            <groupId>com.huaban</groupId>
            <artifactId>jieba-analysis</artifactId>
            <version>1.0.2</version>
        </dependency>
</dependencies>
```

## 转为简体

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.convertToSimple(original);
```

结果为

```
生命不息，奋斗不止
```

## 转为繁体

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.convertToTraditional(original);
```

结果为

```
生命不息，奮鬥不止
```

## 其他支持

上述 2 个方法，都支持 `StringBuilder` 作为入参。

更多详情，可参见测试用例 [ZhConverterUtilTest.java](src/test/java/com/github/houbb/opencc4j/util/ZhConverterUtilTest.java)


# 技术鸣谢

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 提供的原始数据信息。

## 花瓣

[jieba-analysis](https://github.com/huaban/jieba-analysis) 提供中文分词

# Issues & Bugs

[需求和 BUG](https://github.com/houbb/opencc4j/issues) 在这里，欢迎提供宝贵的建议。

# 支持作者

一颗糖，一杯咖啡。

## 支付宝

![AliPay](img/alipay.jpg)

## 微信

![WeChat](img/wechat.jpg)






