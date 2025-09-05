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

- 支持自定义分词、引导类，优雅实现

- 支持判断单个字（词）是否为简体/繁体

- 支持返回字符串中简体/繁体的列表信息 

- 支持中国台湾地区和大陆简体繁简体转换

- 支持中国香港地区和大陆简体繁简体转换

- 支持日文新字和大陆简体繁简体转换

- 兼容双字符汉字，【𨦟】【𪡃】等

> [变更日志](CHANGELOG.md)

## 创作缘由

- OpenCC

[OpenCC](https://github.com/BYVoid/OpenCC) 的思想非常优秀，做的也特别棒。但是没有特别为 java 提供的工具。

# 快速开始

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>opencc4j</artifactId>
    <version>1.14.0</version>
</dependency>
```

## api 概览

核心工具列表如下：

| 序号 | 工具类               | 简介              |
|:---|:------------------|:----------------|
| 1  | ZhConverterUtil   | 基础的繁简体转换        |
| 2  | ZhTwConverterUtil | 中国台湾地区与大陆的繁简体转换 |
| 3  | ZhHkConverterUtil | 中国香港地区与大陆的繁简体转换 |
| 4  | ZhJpConverterUtil | 日文新字与大陆的繁简体转换   |

所有的工具类方法具有相同的方法设计，便于记忆。

核心方法如下：

| 序号  | api 方法                      | 简介               |
|:----|:----------------------------|:-----------------|
| 1   | toSimple(String)            | 转为简体             |
| 2   | toTraditional(String)       | 转为繁体             |
| 3   | simpleList(String)          | 返回包含的简体列表        |
| 4   | traditionalList(String)     | 返回包含的繁体列表        |
| 5   | toSimple(char)              | 返回单个汉字对应的所有简体字列表 |
| 6   | toTraditional(char)         | 返回单个汉字对应的所有繁体字列表 |
| 7   | isSimple(String)            | 是否全部为简体          |
| 8   | isSimple(char)              | 单个字符是否为简体        |
| 9   | containsSimple(String)      | 字符中是否为包含简体       |
| 10  | isTraditional(String)       | 是否全部为繁体          |
| 11  | isTraditional(char)         | 单个字符是否为繁体        |
| 12  | containsTraditional(String) | 字符中是否为包含繁体       |
| 13  | isChinese(String)           | 是否全部为中文          |
| 14  | isChinese(char)         | 单个字符是否为中文        |
| 15  | containsChinese(char)         | 字符串中是否包含中文       |


## 繁简体转换

### 转为简体 toSimple

```java
String original = "生命不息，奮鬥不止";
String result = ZhConverterUtil.toSimple(original);
Assert.assertEquals("生命不息，奋斗不止", result);
```

### 转为繁体 toTraditional

```java
String original = "生命不息，奋斗不止";
String result = ZhConverterUtil.toTraditional(original);
Assert.assertEquals("生命不息，奮鬥不止", result);
```

## 繁简体判断

对单个字符或者词组进行繁简体判断。

### 是否为简体 isSimple

```java
Assert.assertTrue(ZhConverterUtil.isSimple('奋'));
Assert.assertTrue(ZhConverterUtil.isSimple("奋"));
Assert.assertTrue(ZhConverterUtil.isSimple("奋斗"));

Assert.assertFalse(ZhConverterUtil.isSimple('奮'));
Assert.assertFalse(ZhConverterUtil.isSimple("奮"));
Assert.assertFalse(ZhConverterUtil.isSimple("奮鬥"));
Assert.assertFalse(ZhConverterUtil.isSimple("奮斗"));
Assert.assertFalse(ZhConverterUtil.isSimple("beef"));
```

### 是否包含简体 containsSimple

```java
Assert.assertTrue(ZhConverterUtil.containsSimple("奋"));
Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗"));
Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗2023"));

Assert.assertFalse(ZhConverterUtil.containsSimple("編"));
Assert.assertFalse(ZhConverterUtil.containsSimple("編號"));
```

### 是否为繁体 isTraditional

```java
Assert.assertTrue(ZhConverterUtil.isTraditional('編'));
Assert.assertTrue(ZhConverterUtil.isTraditional("編"));
Assert.assertTrue(ZhConverterUtil.isTraditional("編號"));

Assert.assertFalse(ZhConverterUtil.isTraditional('编'));
Assert.assertFalse(ZhConverterUtil.isTraditional("编"));
Assert.assertFalse(ZhConverterUtil.isTraditional("编号"));
Assert.assertFalse(ZhConverterUtil.isTraditional("编號"));
```

### 是否包含繁体 containsTraditional

```java
Assert.assertTrue(ZhConverterUtil.containsTraditional("編"));
Assert.assertTrue(ZhConverterUtil.containsTraditional("編號"));
Assert.assertTrue(ZhConverterUtil.containsTraditional("編號2023"));

Assert.assertFalse(ZhConverterUtil.containsTraditional("号"));
Assert.assertFalse(ZhConverterUtil.containsTraditional("编号"));
```

## 句子中包含的繁简体列表返回

返回字符串中繁简体对应的词、字列表，默认支持中文分词。

繁简体列表返回的词组和分词策略紧密相关。

### 简体列表 simpleList

```java
final String original = "生命不息奋斗不止";
final List<String> resultList = ZhConverterUtil.simpleList(original);

Assert.assertEquals("[生, 命, 不, 息, 奋斗, 不, 止]", resultList.toString());
```

### 繁体列表 traditionalList

PS: 很多字是同体字。

```java
final String original = "生命不息奮鬥不止";
final List<String> resultList = ZhConverterUtil.traditionalList(original);

Assert.assertEquals("[生, 命, 不, 息, 奮, 鬥, 不, 止]", resultList.toString());
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

## 中文工具方法

### 是否为中文 isChinese

```java
Assert.assertTrue(ZhConverterUtil.isChinese("你"));
Assert.assertTrue(ZhConverterUtil.isChinese("你好"));
Assert.assertTrue(ZhConverterUtil.isChinese('你'));

Assert.assertFalse(ZhConverterUtil.isChinese("你0"));
Assert.assertFalse(ZhConverterUtil.isChinese("10"));
Assert.assertFalse(ZhConverterUtil.isChinese('0'));
Assert.assertFalse(ZhConverterUtil.isChinese(""));
Assert.assertFalse(ZhConverterUtil.isChinese(null));
```

### 是否包含中文 containsChinese

```java
Assert.assertTrue(ZhConverterUtil.containsChinese("你"));
Assert.assertTrue(ZhConverterUtil.containsChinese("你好"));
Assert.assertTrue(ZhConverterUtil.containsChinese("你0"));

Assert.assertFalse(ZhConverterUtil.containsChinese("10"));
Assert.assertFalse(ZhConverterUtil.containsChinese(""));
Assert.assertFalse(ZhConverterUtil.containsChinese(null));
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

# 中国香港繁体和大陆简体转换

## 说明

v1.12.0 版本支持。

为保证方法的一致性，引入 `ZhHkConverterUtil` 工具类，支持方法和 `ZhConverterUtil` 保持一致。

## 例子

```java
/**
 * 大陆简体==>香港正體
 * @since 1.12.0
 */
@Test
public void testHkTraditional() {
    String original = "千家万户瞳瞳日 总把新桃换旧符";
    String result = ZhHkConverterUtil.toTraditional(original);
    Assert.assertEquals("千家萬户瞳瞳日 總把新桃換舊符", result);
}

/**
 * 香港正體==>大陆简体
 */
@Test
public void testHkSimple() {
    String original = "千家萬户瞳瞳日 總把新桃換舊符";
    String result = ZhHkConverterUtil.toSimple(original);
    Assert.assertEquals("千家万户瞳瞳日 总把新桃换旧符", result);
}
```


# 日文新字和大陆简体转换

## 说明

v1.13.0 版本支持。

为保证方法的一致性，引入 `ZhJpConverterUtil` 工具类，支持方法和 `ZhConverterUtil` 保持一致。

实际流程：简体==》标准繁体==》日文新字

## 例子

```java
/**
 * 大陆简体==>标准繁体=》日文
 */
@Test
public void testJpTraditional() {
    String original = "我在日本学习音乐，并学习了龙的字。";
    String result = ZhJpConverterUtil.toTraditional(original);
    Assert.assertEquals("我在日本学習音楽，並学習了竜的字。", result);
}

/**
 * 日文=>标准繁体=>简体
 */
@Test
public void testJpSimple() {
    String original = "我在日本学習音楽，並学習了竜的字。";
    String result = ZhJpConverterUtil.toSimple(original);
    Assert.assertEquals("我在日本学习音乐，并学习了龙的字。", result);
}
```

# 配置引导类

## 引导类说明

主要的可配置项包含了分词和数据集合。

二者都是可以配置，并且支持自定义的。

### 默认配置

默认工具类等价于如下：

```java
ZhConvertBootstrap.newInstance()
                .segment(Segments.defaults())
                .dataMap(DataMaps.defaults()).init();
```

### 中国台湾地区配置

中国台湾地区配置等价于：

```java
ZhConvertBootstrap.newInstance()
                .segment(Segments.twFastForward())
                .dataMap(DataMaps.taiwan()).init();
```

## 中文分词策略

### 系统内置分词方式

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

### 自定义

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

final String result = ZhConvertBootstrap.newInstance()
        .segment(segment)
        .init()
        .toTraditional(original);

Assert.assertEquals("寥落古行宮，宮花寂寞紅。白頭宮女在，閒坐說玄宗。測試", result);
```

## 数据接口自定义

不同的地区，对应的转换规则是不同的。

具体参考一下台湾地区的使用方式即可。

### 接口说明

IDataMap 的接口如下。

```java
/**
 * 数据 map 接口
 * @author binbin.hou
 * @since 1.5.2
 */
public interface IDataMap {

    /**
     * 繁体=》简体 词组
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> tsPhrase();

    /**
     * 繁体=》简体 单个字
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> tsChar();

    /**
     * 简体=》繁体 词组
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> stPhrase();

    /**
     * 简体=》繁体 单个字
     * @return 结果
     * @since 1.5.2
     */
    Map<String, List<String>> stChar();

    /**
     * 繁体字所有字符
     * @return 繁体字所有字符
     * @since 1.6.2
     */
    Set<String> tChars();

    /**
     * 简体字所有字符
     * @return 繁体字所有字符
     * @since 1.8.0
     */
    Set<String> sChars();

}
```

### 自定义说明

如果需要拓展对应的数据，建议继承原始的实现，然后添加额外的数据信息即可。

可以参考 [中国台湾地区实现](https://github.com/houbb/opencc4j#%E4%B8%AD%E5%9B%BD%E5%8F%B0%E6%B9%BE%E5%9C%B0%E5%8C%BA%E9%85%8D%E7%BD%AE)

ps: 后续考虑引入更加简单的实现方式，比如基于文本拓展，不过可扩展性没有接口灵活。

# 实际的拓展例子

用于用户参考，可以自定义实现自己的实现，更加符合实际业务。

## 基于基本DataMap的拓展例子

v1.9.0 开始支持，方便用户拓展。

比如首先自定义一个 dataMap 类，集成 AbstractDataMapExtra 可以在指定的 IDataMap 基础上额外指定词组等信息。

```java
public class MyFooDataMapExtra extends AbstractDataMapExtra {

    public MyFooDataMapExtra(IDataMap baseDataMap) {
        super(baseDataMap);
    }

    // 默认在基本的繁简体基础上拓展
    public MyFooDataMapExtra() {
        this(DataMaps.defaults());
    }

    private Map<String, List<String>> of(String key, List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        map.put(key, list);

        return map;
    }

    @Override
    protected Map<String, List<String>> tsPhraseExtra() {
        // 估计写了个错的，用来演示
        return of("風玥", Arrays.asList("风月"));
    }

    @Override
    protected Map<String, List<String>> tsCharExtra() {
        return null;
    }

    @Override
    protected Map<String, List<String>> stPhraseExtra() {
        // 估计写了个错的
        return of("风月", Arrays.asList("風玥"));
    }

    @Override
    protected Map<String, List<String>> stCharExtra() {
        return null;
    }

}
```

### 测试

我们只需要在引导类 ZhConvertBootstrap 指定我们的 dataMap 和对应的分词策略，即可。

```java
// 1.1自定义的额外数据集
final IDataMap dataMap = new MyFooDataMapExtra();
// 1.2 指定分词策略
final Segment segment = new DataMapFastForwardSegment(dataMap);

// 2. 指定
ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
        .dataMap(dataMap)
        .segment(segment)
        .init()
        ;

// 3. 使用
        Assert.assertEquals(bs.toTraditional("人生自是有情痴,此恨不关风月"), "人生自是有情癡,此恨不關風玥");
        Assert.assertEquals(bs.toSimple("人生自是有情癡,此恨不關風玥"), "人生自是有情痴,此恨不关风月");
```


# 是否为繁简体判断

## 说明

V1.11.0 版本支持。

有时候我们需要判断一个字符串是否为繁简体，isSimple()、isTraditional() 默认要求全部匹配，无法满足全部场景。

这里允许用户自定义相关的策略。

## 内置实现

内置策略见 `ZhMatches` 工具方法。

| 策略                    | 说明       | 备注                     |
|:----------------------|:---------|:-----------------------|
| simpleAll()           | 满足全部简体   | isSimple 判断时，默认策略      |
| simpleAny()           | 满足任一简体   | -                      |
| simpleOverHalf()      | 满足超过一半简体 | -                      |
| traditionalAll()      | 满足全部繁体   | isTraditional 判断时，默认策略 |
| traditionalAny()      | 满足任一繁体   | -                      |
| traditionalOverHalf() | 满足超过一半繁体 | -                      |

## 例子

### 简体

```java
// 全部
ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
        .isSimpleMatch(ZhMatches.simpleAll())
        .init();
String text = "123我456";
Assert.assertFalse(bs.isSimple(text));

// 任一
bs.isSimpleMatch(ZhMatches.simpleAny()).init();
Assert.assertTrue(bs.isSimple(text));
```

### 繁体

```java
// 全部
ZhConvertBootstrap bs = ZhConvertBootstrap.newInstance()
        .isTraditionalMatch(ZhMatches.traditionalAll())
        .init();
String text = "123俺們456";
Assert.assertFalse(bs.isTraditional(text));

// 任一
bs.isTraditionalMatch(ZhMatches.traditionalAny()).init();
Assert.assertTrue(bs.isTraditional(text));;
```

## 自定义

如果系统内置的策略不满足，你可以自定义。

实现 ZhMatch 接口，引导类中指定即可使用。

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
