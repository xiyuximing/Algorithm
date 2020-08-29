package com.cy.algorithm.day6;

import java.util.Arrays;

/**
 * KMP算法？回溯还需搞明白
 * Created by Yang on 2020/8/29.
 */
public class ShortestPalindrome {

    /**
     * 最短回文串
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

     示例 1:

     输入: "aacecaaa"
     输出: "aaacecaaa"
     示例 2:

     输入: "abcd"
     输出: "dcbabcd"

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/shortest-palindrome
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 从暴力法可以看出，其实就是求 s 的「最长回文前缀」，然后在 rev_s 的后缀中砍掉这个回文，再加到 s 前面。

     这个最长前缀是回文的，它翻转之后等于它自己，出现在 rev_s 的后缀，这不就是公共前后缀吗？KMP 的 next 数组记录的就是一个字符串的每个位置上，最长公共前后缀的长度。公共前后缀指的是前后缀相同。

     因此，我们 “制造” 出公共前后缀，去套 KMP。

     s：abab，则 s + '#' + rev_s，得到 str ：abab#baba。

     求出 next 数组，最后一项就是 str 的最长公共前后缀的长度，即 s 的最长回文前缀的长度。

     * @param s
     * @return
     */

    /**
     * 具体地，记sr为s的反序，由于s1是s的前缀，那么s1r就是sr的后缀
     * 考虑到s1是个回文串，因此s1=s1r,s1同样是sr的前缀
     * 将s作为模式串，sr作为查询串进行匹配，遍历到sr的末尾时，如果匹配到s中的第i个字符，那么说明s的前i个字符与sr的后i个字符匹配
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        int[] next = new int[len];
        Arrays.fill(next, -1);
        //先计算next数字
        for (int i = 1; i < len; i++) {
            int prefix = next[i - 1];
            //如果最后一个字符与前一个的最大相同前后缀+1不相等，回溯
            while (prefix != -1 && s.charAt(prefix + 1) != s.charAt(i)) {
                prefix = next[prefix];
            }
            //如果最后一个字符与前一个的最大相同前后缀+1相等，则next[i]的最大相同前后缀的长度为前一个+1
            if (s.charAt(prefix + 1) == s.charAt(i)) {
                next[i] = prefix + 1;
            }
        }
        int best = -1;
        //相当于把s反转
        for (int i = len -1 ; i >  -1 ; i--) {
            while (best != -1 && s.charAt(i) != s.charAt(best + 1)) {
                best = next[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                best ++;
            }
        }
        String add = best == len - 1 ? "" : s.substring(best + 1);
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

    public static void main(String[] args) {
        ShortestPalindrome s = new ShortestPalindrome();
        s.shortestPalindrome("aacecaaa");
    }
}
