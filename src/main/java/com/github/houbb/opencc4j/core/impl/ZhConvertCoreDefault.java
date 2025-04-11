package com.github.houbb.opencc4j.core.impl;

import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.CharUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.core.ZhConvertCore;
import com.github.houbb.opencc4j.core.ZhConvertCoreContext;
import com.github.houbb.opencc4j.support.convert.context.impl.DefaultUnitConvertContext;
import com.github.houbb.opencc4j.support.convert.core.UnitConvert;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.segment.Segment;
import com.github.houbb.opencc4j.util.InnerCharUtils;

import java.util.List;
import java.util.Map;

/**
 * 抽象实现类
 * @since 1.10.0
 */
public class ZhConvertCoreDefault implements ZhConvertCore {

    @Override
    public String toSimple(String original, ZhConvertCoreContext context) {
        final IDataMap dataMap = context.dataMap();
        return this.convert(original, context, dataMap.tsPhrase(), dataMap.tsChar());
    }

    @Override
    public String toTraditional(String original, ZhConvertCoreContext context) {
        final IDataMap dataMap = context.dataMap();
        return this.convert(original, context, dataMap.stPhrase(), dataMap.stChar());
    }

    @Override
    public List<String> simpleList(String original, ZhConvertCoreContext context) {
        List<String> simpleList = Guavas.newArrayList();

        List<String> segList = context.segment().seg(original);
        for(String seg : segList) {
            if(isSimple(seg, context)) {
                simpleList.add(seg);
            }
        }
        return simpleList;
    }

    @Override
    public List<String> traditionalList(String original, ZhConvertCoreContext context) {
        List<String> traditionalList = Guavas.newArrayList();

        List<String> segList = context.segment().seg(original);
        for(String seg : segList) {
            if(isTraditional(seg, context)) {
                traditionalList.add(seg);
            }
        }
        return traditionalList;
    }

    @Override
    public boolean isSimple(char c, ZhConvertCoreContext context) {
        String sc = String.valueOf(c);
        return isSimpleForSingle(sc, context);
    }

    @Override
    public boolean isSimple(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        //TODO: 这里可以抽象为 allMatch 和 anyMatch，避免写这么多次。下次优化.
        // 将 isXXX 抽象为 condition 接口
        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            if(!isSimpleForSingle(c, context)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSimpleForSingle(String c, ZhConvertCoreContext context) {
        if(!isChinese(c, context)) {
            return false;
        }

        // 中文简体字符集中包含
        final IDataMap dataMap = context.dataMap();
        if(dataMap.sChars().contains(c)) {
            return true;
        }

        // 中文除去繁体的，认为是简体
        return !isTraditional(c, context);
    }

    @Override
    public boolean containsSimple(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            if(isSimple(c, context)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isTraditional(char c, ZhConvertCoreContext context) {
        String sc = String.valueOf(c);
        return isTraditionalForSingle(sc, context);
    }

    @Override
    public boolean isTraditional(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            if(!isTraditionalForSingle(c, context)) {
                return false;
            }
        }

        //3. 返回
        return true;
    }

    private boolean isTraditionalForSingle(String c, final ZhConvertCoreContext context) {
        if(!isChinese(c, context)) {
            return false;
        }

        // 繁体字符包含
        return context.dataMap().tChars().contains(c);
    }

    @Override
    public boolean containsTraditional(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            if(isTraditional(c, context)) {
                return true;
            }
        }

        //3. 返回
        return false;
    }

    @Override
    public boolean isChinese(char c, ZhConvertCoreContext context) {
        // 单个字符，直接简单判断
        return CharUtil.isChinese(c);
    }

    @Override
    public boolean isChinese(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        // 遍历
        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            // 兼容双字符
            if(!InnerCharUtils.isChineseForSingle(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean containsChinese(String charOrPhrase, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charOrPhrase)) {
            return false;
        }

        // 遍历
        List<String> chars = context.zhChars().chars(charOrPhrase);
        for(String c : chars) {
            if(this.isChinese(c, context)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> toSimple(char c, ZhConvertCoreContext context) {
        final IDataMap dataMap = context.dataMap();
        return dataMap.tsChar().get(String.valueOf(c));
    }

    @Override
    public List<String> toTraditional(char c, ZhConvertCoreContext context) {
        final IDataMap dataMap = context.dataMap();
        return dataMap.stChar().get(String.valueOf(c));
    }

    /**
     * 指定转换
     * @param original 原始字符串
     * @param context 上下文
     * @param phraseData 词组数据
     * @param charData 单个字数据
     * @return 转换后的结果
     * @since 1.10.0
     */
    protected String convert(final String original,
                             final ZhConvertCoreContext context,
                             final Map<String, List<String>> phraseData,
                             final Map<String, List<String>> charData) {

        //1. fast-fail
        if(StringUtil.isEmpty(original)) {
            return original;
        }

        final Segment segment = context.segment();
        List<String> stringList = segment.seg(original);
        if(CollectionUtil.isEmpty(stringList)) {
            return original;
        }

        //2. 转换对象构建
        final UnitConvert unitConvert = context.unitConvert();
        final DefaultUnitConvertContext unitConvertContext = new DefaultUnitConvertContext();
        unitConvertContext.setPhraseData(phraseData);
        unitConvertContext.setCharData(charData);

        //3. 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : stringList) {
            unitConvertContext.setUnit(string);
            String result = unitConvert.convert(unitConvertContext);
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

}
