package com.cy.algorithm.Oct1;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yang on 2020/10/2.
 */
public class NumJewelsInStones {

    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

     J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

     示例 1:

     输入: J = "aA", S = "aAAbbbb"
     输出: 3
     示例 2:

     输入: J = "z", S = "ZZ"
     输出: 0
     注意:

     S 和 J 最多含有50个字母。
      J 中的字符不重复。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/jewels-and-stones
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int numJewelsInStones(String J, String S) {
        if (S == null || S.isEmpty()) return 0;
        if (J == null || J.isEmpty()) return 0;

        byte[] arr = new byte[58];
        int count = 0;
        for (char ch : J.toCharArray()) {
            arr[ch - 65] = 1;
        }
        for (char ch : S.toCharArray()) {
            if(arr[ch -65] == 1) {
                count++;
            }
        }
        return count;

    }
}
