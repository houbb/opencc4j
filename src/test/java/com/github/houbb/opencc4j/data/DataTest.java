package com.github.houbb.opencc4j.data;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.opencc4j.support.datamap.IDataMap;
import com.github.houbb.opencc4j.support.datamap.impl.DataMaps;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.plaf.SpinnerUI;
import java.io.IOException;
import java.util.*;

/**
 * @author binbin.hou
 * @since 1.6.2
 */
@Ignore
public class DataTest {

    /**
     * 获取所有的繁体字
     * @since 1.6.2
     */
    @Test
    public void getAllTCharsTest() {
        Set<String> set = new HashSet<>();

        List<String> stC = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\STCharacters.txt");
        for(String st : stC) {
            String[] strings = st.split(" ");
            // 排除第一个，都是繁体
            for(int i = 1; i < strings.length; i++) {
                set.add(strings[i]);
            }
        }
        List<String> stP = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\STPhrases.txt");
        for(String st : stP) {
            String[] strings = st.split(" ");
            // 排除第一个，都是繁体
            for(int i = 1; i < strings.length; i++) {
                set.addAll(StringUtil.toCharStringList(strings[i]));
            }
        }

        List<String> tsC = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\TSCharacters.txt");
        for(String ts : tsC) {
            String[] strings = ts.split(" ");
            // 第一个是繁体
            set.add(strings[0]);
        }
        List<String> tsP = FileUtil.readAllLines("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\TSPhrases.txt");
        for(String ts : tsP) {
            String[] strings = ts.split(" ");
            // 第一个是繁体
            set.addAll(StringUtil.toCharStringList(strings[0]));
        }


        // 排序
        List<String> list = new ArrayList<>(set);
        CollectionUtil.sort(list);

        // 写入
        FileUtil.write("D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\tc.txt",
                list);
    }

    /**
     * 获取所有的简体字
     * @since 1.6.2
     */
    @Test
    public void getAllSCharsTest() throws IOException {
        List<String> list = new ArrayList<>();

        IDataMap dataMap = DataMaps.defaults();

        list.addAll(dataMap.stChar().keySet());
        list.addAll(dataMap.stPhrase().keySet());

        for(Collection<String> values : dataMap.tsChar().values()) {
            list.addAll(values);
        }
        for(Collection<String> values : dataMap.tsPhrase().values()) {
            list.addAll(values);
        }

        // 排序
        String line = StringUtil.join(list,"");
        List<String> list2 = CollectionUtil.distinct(StringUtil.toCharStringList(line));
        List<String> list3 = CollectionUtil.sort(list2);
        CollectionUtil.foreachPrint(list3);

        // 写入
//        String path = "D:\\gitee2\\opencc4j\\src\\main\\resources\\data\\dictionary\\sc.txt";
//        FileUtil.write(path, list3, "UTF-8");
    }

//    @Test
//    public void

}
