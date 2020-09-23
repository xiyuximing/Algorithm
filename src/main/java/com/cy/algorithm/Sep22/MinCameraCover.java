package com.cy.algorithm.Sep22;

import com.cy.algorithm.entity.TreeNode;

/**
 * Created by Yang on 2020/9/22.
 */
public class MinCameraCover {

    /**
     * 968. 监控二叉树
     给定一个二叉树，我们在树的节点上安装摄像头。

     节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

     计算监控树的所有节点所需的最小摄像头数量。



     示例 1：



     输入：[0,0,null,0,0]
     输出：1
     解释：如图所示，一台摄像头足以监控所有节点。
     示例 2：



     输入：[0,0,null,0,null,0,null,null,0]
     输出：2
     解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

     提示：

     给定树的节点数的范围是 [1, 1000]。
     每个节点的值都是 0。
     */

    /**
     * 每个节点都有三种状态
     *1，当前节点有相机
     2，当前节点不需要相机（子节点有相机把它给覆盖了）
     3，当前节点没有相机并且也没有被子节点给覆盖（那么他只能等他的父节点把它给覆盖了）
     */
    int count = 0;
    int hasCamera = 1;
    int noNeedCamera = 2;
    int hasNoCamera = 3;
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return count;
        }
        if (dfs(root) == hasNoCamera) {
            count ++;
        }
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return noNeedCamera;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        //左或右子节点处于状态3，则必须增加一个摄像头
        if (left == hasNoCamera || right == hasNoCamera) {
            count ++;
            return hasCamera;
        }
        if (left == hasCamera || right == hasCamera) {
            return noNeedCamera;
        }
        return hasNoCamera;
    }
}
