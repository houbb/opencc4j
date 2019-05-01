# opencc4j

Opencc4j is an opensource project for conversion between Traditional Chinese and Simplified Chinese, 
supporting character-level conversion, phrase-level conversion for java.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Build Status](https://www.travis-ci.org/houbb/opencc4j.svg?branch=master)](https://www.travis-ci.org/houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)

> [中文简介](README.md)

## Features

- Strict distinction between "a simple and complex" and "a simple and diverse".

- Fully compatible with different characters, you can achieve dynamic replacement.

- Strict review of a simple and more complicated entries, the principle of "can be divided but not consistent."

- Thesaurus and function library completely separated, you can freely modify, import, expand.

- Compatible with Windows, Linux, Mac platform.

## Why write this

- OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) is an awesome project, but not have direct support jar for java.

- jopencc

[jopencc](https://github.com/carlostse/jopencc) has no word segmentation provided.

# Quick Start

## maven import

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>opencc4j</artifactId>
    <version>1.0.2</version>
</dependency>
```

## convert to simple

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.convertToSimple(original);
```

the result is:

```
生命不息，奋斗不止
```

## convert to traditional

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.convertToTraditional(original);
```

the result is:

```
生命不息，奮鬥不止
```



# Thanks

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) support the original data.

## HUABAN

[jieba-analysis](https://github.com/huaban/jieba-analysis) support the Chinese word segmentation

# Issues & Bugs

[Issues & Bugs](https://github.com/houbb/opencc4j/issues), welcome to provide valuable suggestions.






