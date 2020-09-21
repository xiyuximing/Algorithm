package com.cy.algorithm.Sep17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2020/9/18.
 */
public class PermuteUnique {
    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

     示例:

     输入: [1,1,2]
     输出:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/permutations-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    boolean[] booleans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        booleans = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !booleans[i-1]) || booleans[i]) {
                continue;
            }
            list.add(nums[i]);
            booleans[i] = true;
            dfs(nums, index + 1, list, result);
            booleans[i] = false;
            list.remove(index);
        }

    }
}
