package com.cy.algorithm.Oct3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2020/10/3.
 */
public class TwoSum {

    /**
     * 1. 两数之和
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。



     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) != null) {
                return new int[] {i, map.get(num)};
            }
            map.put(target - num, i);
        }
        return null;
    }
}
