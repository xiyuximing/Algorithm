package com.cy.algorithm.Sep19;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/20.
 */
public class Subsets {
    /**
     * 78. 子集
     给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

     说明：解集不能包含重复的子集。

     示例:

     输入: nums = [1,2,3]
     输出:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     */

    public List<List<Integer>> subsets(int[] nums) {
        //长度为n的数组应该有2的n次方个结果
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< 1 << nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j ++) {
                //第i种组合的第j位是否为1
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
