package com.cy.algorithm.Sep14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/14.
 */
public class InorderTraversal {
    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,3,2]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？

     */

    /**
     * 中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树
     */

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        list.add(treeNode.val);
        dfs(treeNode.right, list);
    }
}
