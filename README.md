# opencc4j

Opencc4j 支持中文繁简体转换，考虑到词组级别。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/opencc4j/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/opencc4j)
[![Coverage Status](https://coveralls.io/repos/github/houbb/opencc4j/badge.svg)](https://coveralls.io/github/houbb/opencc4j)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/opencc4j/blob/master/LICENSE.txt)


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
    <version>1.3.0</version>
</dependency>
```

## 转为简体

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.toSimple(original);
```

结果为

```
生命不息，奋斗不止
```

## 转为繁体

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.toTraditional(original);
```

结果为

```
生命不息，奮鬥不止
```

# 引导类方式

## 为什么需要引导类

v1.1.0 之后引入了类 [ZhConvertBootstrap](https://github.com/houbb/opencc4j/blob/release_1.1.0/src/main/java/com/github/houbb/opencc4j/core/impl/ZhConvertBootstrap.java)

可以提供更加灵活的功能，支持 fluent 语法。

## 对比静态方法的优势

工具类的静态方法使用起来很方便，但是不是很利于拓展变化。

后期想添加更多的方法，就会发现静态方法开始有些不够优雅，方法数量也会变得较多。所以自定义分词没有暴露静态方法，

建议用户根据 ZhConvertBootstrap 灵活创建属于自己的工具类。

## 引导类使用案例

和工具类类似。

- 转为简体

```java
final String original = "生命不息，奮鬥不止";
final String result = ZhConvertBootstrap.newInstance().toSimple(original);
Assert.assertEquals("生命不息，奋斗不止", result);
```

- 转为繁体

```java
final String original = "生命不息，奋斗不止";
final String result = ZhConvertBootstrap.newInstance().toTraditional(original);
Assert.assertEquals("生命不息，奮鬥不止", result);
```

# 自定义分词方式

## 用途

你有时候可能除了上述的两种分词方式，会有更加适合自己业务的分词实现。

Opencc4j 支持自定义分词实现。

## 自定义

只需要实现分词接口 [Segment](https://github.com/houbb/opencc4j/blob/release_1.1.0/src/main/java/com/github/houbb/opencc4j/support/segment/Segment.java)

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

备注： 默认使用的是 [花瓣分词](https://github.com/houbb/opencc4j/blob/master/src/main/java/com/github/houbb/opencc4j/support/segment/impl/HuaBanSegment.java)

## 测试代码

- 自定义分词实现类

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

- 分词测试

我们自定义的分词，直接在默认添加“测试”这样的信息。

```java
final String result2 = ZhConvertBootstrap.newInstance().segment(new FooSegment()).toTraditional(original);
Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result2);
```

- 创建时指定分词器

你可以在创建引导类的时候，直接指定分词器实现。

```java
final String original = "寥落古行宫，宫花寂寞红。白头宫女在，闲坐说玄宗。";
final String result = ZhConvertBootstrap.newInstance(new FooSegment()).toTraditional(original);
Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
```

# V1.2.0 新特性使用说明

## 获取分词列表

- 方法

```java
/**
 * 获取分词后的字符串列表
 * （1）如果原始字符串为空，则返回空列表
 * @param original 原始字符串
 * @return 字符串列表
 * @since 1.2.0
 */
List<String> doSeg(final String original);
```

- 测试

```java
final String original = "生命不息奋斗不止";
final List<String> resultList = ZhConvertBootstrap.newInstance().doSeg(original);

String expectToString = "[生命不息, 奋斗, 不止]";
Assert.assertEquals(expectToString, resultList.toString());
```

## 判断是否为繁体

- 方法

```java
/**
 * 是否为繁体
 * 1. 原始字符串为空，直接返回 false
 * 2. 如果长度为1，则根据繁体字列表中是否存在，直接返回结果
 * 3. 如果长度大于1，则判断繁体词组类表中是否存在，如果为 true，则直接返回。
 * 4. 如果 3 为 false，则继续判断分成单个字进行判断，如果每一个字都是繁体，则认为是繁体。
 * @param charOrPhrase 单个字或者词组
 * @return true: 是; false: 否
 * @since 1.2.0
 */
boolean isTraditional(final String charOrPhrase);
```

- 测试

```java
final String simpleChar = "奋";
final String simplePhrase = "奋斗";
final String traditionalChar = "奮";
final String traditionalPhrase = "奮鬥";

ZhConvertBootstrap convertBootstrap = ZhConvertBootstrap.newInstance();

Assert.assertTrue(convertBootstrap.isTraditional(traditionalChar));
Assert.assertTrue(convertBootstrap.isTraditional(traditionalPhrase));
Assert.assertFalse(convertBootstrap.isTraditional(simpleChar));
Assert.assertFalse(convertBootstrap.isTraditional(simplePhrase));
```

## 判断是否为简体

- 方法

```java
/**
 * 是否为简体
 * （1）原始字符串为空，直接返回 false
 * （2）其他情况，则和 {@link #isTraditional(String)} 取反
 * @param charOrPhrase 单个字或者词组
 * @return true: 是; false: 否
 * @since 1.2.0
 */
boolean isSimple(final String charOrPhrase);
```

- 测试

```java
final String simpleChar = "奋";
final String simplePhrase = "奋斗";
final String traditionalChar = "奮";
final String traditionalPhrase = "奮鬥";

ZhConvertBootstrap convertBootstrap = ZhConvertBootstrap.newInstance();

Assert.assertTrue(convertBootstrap.isSimple(simpleChar));
Assert.assertTrue(convertBootstrap.isSimple(simplePhrase));
Assert.assertFalse(convertBootstrap.isSimple(traditionalChar));
Assert.assertFalse(convertBootstrap.isSimple(traditionalPhrase));
```

## 返回简体字符串列表

- 方法

```java
/**
 * 返回简体字列表
 * 说明：返回 {@link #doSeg(String)} 列表中符合 {@link #isSimple(String)} 的字符串列表
 * @param original 原始字符串列表
 * @return 包含的简体字符串列表
 * @since 1.2.0
 */
List<String> simpleList(final String original);
```

- 测试

```java
final String original = "生命不息奋斗不止";
ZhConvertBootstrap zhConvertBootstrap = ZhConvertBootstrap.newInstance();
final List<String> resultList = zhConvertBootstrap.simpleList(original);

String expectToString = "[生命不息, 奋斗, 不止]";
Assert.assertEquals(expectToString, resultList.toString());
```

## 返回繁体字符串列表

- 方法

```java
/**
 * 返回繁体字列表
 * 说明：返回 {@link #doSeg(String)} 列表中符合 {@link #isTraditional(String)} 的字符串列表
 * @param original 原始字符串列表
 * @return 包含的繁体字符的列表
 * @since 1.2.0
 */
List<String> traditionalList(final String original);
```

- 测试

```java
final String original = "生命不息奮鬥不止";
ZhConvertBootstrap zhConvertBootstrap = ZhConvertBootstrap.newInstance();
final List<String> resultList = zhConvertBootstrap.traditionalList(original);

String expectToString = "[奮鬥]";
Assert.assertEquals(expectToString, resultList.toString());
```

# 技术鸣谢

## OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 提供的原始数据信息。

## 花瓣

[jieba-analysis](https://github.com/huaban/jieba-analysis) 提供中文分词

# Issues & Bugs

[需求和 BUG](https://github.com/houbb/opencc4j/issues) 在这里，欢迎提供宝贵的建议。