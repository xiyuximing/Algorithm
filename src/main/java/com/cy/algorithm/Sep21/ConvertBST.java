package com.cy.algorithm.Sep21;

import com.cy.algorithm.entity.TreeNode;

/**
 * Created by Yang on 2020/9/21.
 */
public class ConvertBST {
    /**
     * 538. 把二叉搜索树转换为累加树
     给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。



     例如：

     输入: 原始二叉搜索树:
     5
     /   \
     2     13

     输出: 转换为累加树:
     18
     /   \
     20     13

     */

    /**
     * 二叉搜索树是一棵空树，或者是具有下列性质的二叉树：

     若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；

     若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；

     它的左、右子树也分别为二叉搜索树。

     计算结果就是，右子节点保持不变，中间节点的值是其本身与右子节点相加的和，左子节点的值是其本身与中间节点、右子节点三者的累计之和
     定义一个全局变量sum，用于存储遍历的所有节点值的累计和；
     递归终止条件： root为空就返回null;
     递归右子树root.right;
     遍历当前节点，作如下操作：
     将其值累加到sum中；
     把sum赋值给当前节点的值；
     递归左子树root.left;

     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
