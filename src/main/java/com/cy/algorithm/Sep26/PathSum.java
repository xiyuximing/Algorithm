package com.cy.algorithm.Sep26;

import com.cy.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/26.
 */
public class PathSum {

    /**
     * 113. 路径总和 II
     给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

     说明: 叶子节点是指没有子节点的节点。

     示例:
     给定如下二叉树，以及目标和 sum = 22，

     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     返回:

     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     */

    List<List<Integer>> result = new ArrayList<>();
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        sum = sum + node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == this.sum) {
            result.add(new ArrayList<>(list));
        }
        dfs(node.left, sum, list);
        dfs(node.right, sum, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        node.left = node4;
        node.right = node8;
        List<List<Integer>> list = new PathSum().pathSum(node, 9);
        System.out.print(list.size());
    }
}
