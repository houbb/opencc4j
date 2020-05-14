# Opencc4j

[Opencc4j](https://github.com/houbb/opencc4j) 支持中文繁簡體轉換，考慮到詞組級別。

[![Build Status](https://travis-ci.com/houbb/opencc4j.svg?branch=master)](https://travis-ci.com/houbb/opencc4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/opencc4j/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/opencc4j)

[简体中文](README.md)

## Features 特點

- 嚴格區分「一簡對多繁」和「一簡對多異」。

- 完全兼容異體字，可以實現動態替換。

- 嚴格審校一簡對多繁詞條，原則為「能分則不合」。

- 詞庫和函數庫完全分離，可以自由修改、導入、擴展。

- 兼容 Windows、Linux、Mac 平台。

- 支持自定義分詞

- 支持判斷單個字（詞）是否為簡體/繁體

- 支持返回字符串中簡體/繁體的列表信息

### v1.5.1 版本變更

- 修復 DataUtil.buildDataMap() 中流關閉問題 (Fixed [#12](https://github.com/houbb/opencc4j/issues/12))

> [變更日誌](CHANGELOG.md)

## 測試代碼

見 test 文件夾。

可以用來學習相關方法的使用方式。

## 創作緣由

- OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 的思想非常優秀，做的也特別棒。但是沒有特別為 java 提供的工具。

- jopencc

[jopencc](https://github.com/carlostse/jopencc) 沒有提供分詞功能。

# 快速開始

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>opencc4j</artifactId>
    <version>1.5.1</version>
</dependency>
```

## api 概覽

工具類方法參見 [ZhConverterUtil](https://github.com/houbb/opencc4j/blob/master/src/main/java/com/github/houbb/opencc4j/util/ZhConverterUtil.java) 工具類。

核心方法如下：

| 序號 | api 方法 | 簡介 |
|:---|:---|:---|
| 1 | toSimple(String) | 轉為簡體 |
| 2 | toTraditional(String) | 轉為繁體 |
| 3 | simpleList(String) | 返回簡體列表 |
| 4 | traditionalList(String) | 返回繁體列表 |
| 5 | isSimple(String) | 是否為簡體 |
| 6 | isTraditional(String) | 是否為繁體 |

以上所有方法都有一個 Segment 參數，可以用於自定義[中文分詞策略](#中文分詞策略)。

## 繁簡體轉換

### 轉為簡體

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.toSimple(original);
Assert.assertEquals("生命不息，奋斗不止", result);
```

### 轉為繁體

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.toTraditional(original);
Assert.assertEquals("生命不息，奮鬥不止", result);
```

## 繁簡體判斷

對單個字符或者詞組進行繁簡體判斷。

### 是否為簡體

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

### 是否為繁體

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

## 繁簡體列表返回

返回字符串中繁簡體對應的詞、字列表，默認支持中文分詞。

繁簡體列表返回的詞組和分詞策略緊密相關。

### 簡體列表

```java
final String original = "生命不息奋斗不止";
final List<String> resultList = ZhConverterUtil.simpleList(original);

Assert.assertEquals("[生, 命, 不, 息, 奋斗, 不, 止]", resultList.toString());
```

### 繁體列表

```java
final String original = "生命不息奮鬥不止";
final List<String> resultList = ZhConverterUtil.traditionalList(original);

Assert.assertEquals("[奮, 鬥]", resultList.toString());
```

# 中文分詞策略

## 系統內置分詞方式

你可以通過 `Segments` 工具類獲取系統內置的分詞實現。

| 序號 | 方法 | 準確性 | 性能 | 備註 |
|:---|:---|:---|:---|:---|
| 1 | defaults() | 高 | 高 | 默認分詞形式，暫時為 `fastForward` 策略 |
| 2 | fastForward() | 較高 | 高 | fast-forward 分詞策略 |
| 3 | chars() | 低 | 高 | 將字符串轉換為單個字符列表，一般不建議使用 |
| 4 | huaBan() | 高 | 一般 | 花瓣的結巴分詞策略 |

### 花瓣結巴分詞

花瓣結巴分詞在使用時，需要自行引入結巴分詞依賴。

```xml
<dependency>
    <groupId>com.huaban</groupId>
    <artifactId>jieba-analysis</artifactId>
    <version>1.0.2</version>
</dependency>
```

## 自定義

你有時候可能除了上述的兩種分詞方式，會有更加適合自己業務的分詞實現。

Opencc4j 支持自定義分詞實現，只需要實現分詞接口 [Segment](https://github.com/houbb/opencc4j/blob/master/src/main/java/com/github/houbb/opencc4j/support/segment/Segment.java)

- 接口內容

```java
public interface Segment {

    /**
    * 分詞
    * @param original 原始信息
    * @return 分詞後的列表
    */
    List<String> seg(final String original);

}
```

## 測試代碼

### 自定義分詞實現類

```java
/**
* 一個最簡單的分詞實現。
* 注意：僅僅做演示，不可實際使用。
*/
public class FooSegment implements Segment {
    @Override
    public List<String> seg(String original) {
        return Arrays.asList(original, "测试");
    }
}
```

### 分詞測試

我們自定義的分詞，直接在默認添加“測試”這樣的信息。

```java
final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
final Segment segment = new FooSegment();
final String result = ZhConverterUtil.toTraditional(original, segment);

Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
```
# 技術鳴謝

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 提供的原始數據信息。

## 花瓣

[jieba-analysis](https://github.com/huaban/jieba-analysis) 提供中文分詞

# Issues & Bugs

[需求和 BUG](https://github.com/houbb/opencc4j/issues) 在這裡，歡迎提供寶貴的建議。

如果對您有幫助，歡迎 Star 鼓勵作者。