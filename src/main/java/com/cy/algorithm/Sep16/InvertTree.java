package com.cy.algorithm.Sep16;

import com.cy.algorithm.entity.TreeNode;

/**
 * Created by Yang on 2020/9/16.
 */
public class InvertTree {
    /**
     * 翻转一棵二叉树。

     示例：

     输入：

     4
     /   \
     2     7
     / \   / \
     1   3 6   9
     输出：

     4
     /   \
     7     2
     / \   / \
     9   6 3   1

     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        dfs(node, root);
        return node;
    }

    private void dfs(TreeNode newRoot, TreeNode oldNode) {
        if (oldNode == null) {
            return;
        }
        if (oldNode.left != null) {
            newRoot.right = new TreeNode(oldNode.left.val);
            dfs(newRoot.right, oldNode.left);
        }
        if (oldNode.right != null) {
            newRoot.left = new TreeNode(oldNode.right.val);
            dfs(newRoot.left, oldNode.right);
        }
    }
}
