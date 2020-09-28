package com.cy.algorithm.Sep27;

import com.cy.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/27.
 */
public class LowestCommonAncestor {

    /**
     * 235. 二叉搜索树的最近公共祖先
     给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]





     示例 1:

     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     输出: 6
     解释: 节点 2 和节点 8 的最近公共祖先是 6。
     示例 2:

     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     输出: 2
     解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。


     说明:

     所有节点的值都是唯一的。
     p、q 为不同节点且均存在于给定的二叉搜索树中。
     */

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pPath = getPath(root, p);
//        List<TreeNode> qPath = getPath(root, q);
//        TreeNode result = null;
//        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
//            if (pPath.get(i).val == qPath.get(i).val) {
//                result = pPath.get(i);
//            } else {
//                break;
//            }
//        }
//        return result;
//    }
//
//    private List<TreeNode> getPath(TreeNode root, TreeNode path) {
//        List<TreeNode> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//
//        while (root.val != path.val) {
//            list.add(root);
//            if (root.val < path.val) {
//                root = root.right;
//            } else {
//                root = root.left;
//            }
//        }
//        list.add(path);
//        return list;
//    }

    /**
     * 一次遍历，如果当前节点的值大于p和q，则往左，如果小于p和q则往右，否则该节点就是要的结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                result = root;
                break;
            }
        }
        return result;
    }
}
