package com.cy.algorithm.day1;

/**
 * Created by Yang on 2020/8/24.
 */
public class RepeatedSubstringPattern {
    /**
     * 题目：重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     */
    /**
     * 题解：
     * 对于一个s字符串，s=xxxxxxx,s+s = xxxxxxxxxxxxxx
     *去掉首尾字符的话, 只会破坏掉首尾的 x, 中间的 x 不受影响
     *那么中间 x 的数目 2n - 2 >= n, 所以一定包含一个 s
     *
     *
     */


    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

}
