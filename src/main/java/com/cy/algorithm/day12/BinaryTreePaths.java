package com.cy.algorithm.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/5.
 */
public class BinaryTreePaths {

    /**
     * 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

     说明: 叶子节点是指没有子节点的节点。

     示例:

     输入:

     1
     /   \
     2     3
     \
     5

     输出: ["1->2->5", "1->3"]

     解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/binary-tree-paths
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        String sb = new String();
        getPath(root, sb);
        return result;
    }

    public void getPath(TreeNode node, String sb) {

        if (sb == null || sb.length() == 0) {
            sb = node.val + "";
        } else {
            sb = sb + "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
            return;
        }
        if (node.left != null) {
            getPath(node.left, sb);
        }
        if (node.right != null) {
            getPath(node.right, sb);
        }
    }
}
