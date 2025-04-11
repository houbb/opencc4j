package com.github.houbb.opencc4j.support.match.impl;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.opencc4j.core.ZhConvertCoreContext;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.match.ZhMatch;
import com.github.houbb.opencc4j.util.InnerCharUtils;

import java.util.List;

public abstract class AbstractZhMatch implements ZhMatch {

    protected abstract boolean doMatch(String text, List<String> chars, ZhConvertCoreContext context);

    @Override
    public boolean match(String text, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(text)) {
            return false;
        }

        List<String> chars = context.zhChars().chars(text);

        return doMatch(text, chars, context);
    }

    /**
     * 是否为中文
     * @param charSeg 字符分割后
     * @param context 上下文
     * @return 结果
     */
    protected boolean isChinese(String charSeg, ZhConvertCoreContext context) {
        if(StringUtil.isEmpty(charSeg)) {
            return false;
        }

        // 遍历
        return InnerCharUtils.isChineseForSingle(charSeg);
    }

    protected boolean isTraditional(String charSeg, ZhConvertCoreContext context) {
        if(!isChinese(charSeg, context)) {
            return false;
        }

        // 中文简体字符集中包含
        final IDataMap dataMap = context.dataMap();
        if(dataMap.tChars().contains(charSeg)) {
            return true;
        }

        return false;
    }

    protected boolean isSimple(String charSeg, ZhConvertCoreContext context) {
        if(!isChinese(charSeg, context)) {
            return false;
        }

        // 中文简体字符集中包含
        final IDataMap dataMap = context.dataMap();
        if(dataMap.sChars().contains(charSeg)) {
            return true;
        }

        return false;
    }

}
