package com.cy.algorithm.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/5.
 */
public class GetPermutation {

    /**
     * 第k个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

     按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     给定 n 和 k，返回第 k 个排列。

     说明：

     给定 n 的范围是 [1, 9]。
     给定 k 的范围是[1,  n!]。
     示例 1:

     输入: n = 3, k = 3
     输出: "213"
     示例 2:

     输入: n = 4, k = 9
     输出: "2314"

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/permutation-sequence
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String getPermutation(int n, int k) {
        //将数字加入数组中
        List<Integer> ints = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ints.add(i+1);
        }
        int[] nums = new int[n];
        nums[n-1] = 1;
        //第一个数字有(n-1)!种可能，第二个数字有(n-2)!种可能，依次类推。。。
        for (int i = n - 2; i >= 0; i--) {
            nums[i] = nums[i+1] * (n - i - 1);
        }
        StringBuffer sb = new StringBuffer();
        k = k -1;
        for (int i = 0; i < n; i++) {
            //计算下标
            int index = k / nums[i];
            sb.append(ints.get(index));
            k = k % nums[i];
            //移除已经算过的数字
            ints.remove(ints.get(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(3, 3));
    }
}
