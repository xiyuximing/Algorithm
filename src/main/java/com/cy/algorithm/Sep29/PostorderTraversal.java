package com.cy.algorithm.Sep29;

import com.cy.algorithm.entity.Node;
import com.cy.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/29.
 */
public class PostorderTraversal {
    /**
     * 145. 二叉树的后序遍历
     给定一个二叉树，返回它的 后序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [3,2,1]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        list.add(node.val);
    }
}
