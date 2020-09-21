package com.cy.algorithm.Sep18;

import com.cy.algorithm.entity.TreeNode;

/**
 * Created by Yang on 2020/9/19.
 */
public class SumOfLeftLeaves {
    /**
     * 计算给定二叉树的所有左叶子之和。

     示例：

     3
     / \
     9  20
     /  \
     15   7

     在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sum-of-left-leaves
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return sum;
    }

    private void dfs(TreeNode root, boolean add) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && add) {
            sum += root.val;
        } else {
            dfs(root.left, true);
            dfs(root.right, false);
        }

    }
}
