package com.cy.algorithm.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yang on 2020/8/25.
 */
public class FindSubsequences {
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * 说明:
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是 [-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     */
    Set<List<Integer>> set = new HashSet<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        for (int i = 0; i < nums.length; i ++) {
            dfs(nums, i, Integer.MIN_VALUE);
        }
        return new ArrayList<List<Integer>>(set);
    }

    public void dfs(int[] nums, int index, int pre) {
        if (index > nums.length-1) {
            if (temp.size() > 1) {
                set.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (pre <= nums[index]) {
            temp.add(nums[index]);
            for (int i = index + 1; i < nums.length; i++) {
                dfs(nums, i, nums[index]);
            }
            temp.remove(temp.size() -1);
        } else {
            if (temp.size() > 1) {
                set.add(new ArrayList<Integer>(temp));
            }
        }
    }

    public static void main(String[] args) {
        FindSubsequences f = new FindSubsequences();
        f.findSubsequences(new int[]{4,6,7,7});
    }
}
