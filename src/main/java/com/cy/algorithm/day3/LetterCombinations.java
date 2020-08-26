package com.cy.algorithm.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yang on 2020/8/26.
 */
public class LetterCombinations {

    /**
     * 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
         示例:

         输入："23"
         输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    Map<Character, String[]> map = new HashMap<Character, String[]>(8);
    public List<String> letterCombinations(String digits) {
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        List<String> list = new ArrayList<String>();
        for (int i = digits.length(); i > 0 ; i--) {
            list = getStringList(list, map.get(digits.charAt(i-1)));
        }
        return list;
    }

    public List<String> getStringList(List<String> oldList, String[] ss) {
        List<String> newList = new ArrayList<String>();
        for (String s : ss) {
            if (oldList == null || oldList.isEmpty()) {
                newList.add(s);
            } else {
                for (String olds : oldList) {
                    String news = s + olds;
                    newList.add(news);
                }
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        List<String> list = l.letterCombinations("23");
        System.out.print(list.toArray());
    }
}

