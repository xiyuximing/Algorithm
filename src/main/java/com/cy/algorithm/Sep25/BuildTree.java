package com.cy.algorithm.Sep25;

import com.cy.algorithm.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2020/9/25.
 */
public class BuildTree {
    /**
     * 106. 从中序与后序遍历序列构造二叉树
     根据一棵树的中序遍历与后序遍历构造二叉树。

     注意:
     你可以假设树中没有重复的元素。

     例如，给出

     中序遍历 inorder = [9,3,15,20,7]
     后序遍历 postorder = [9,15,7,20,3]
     返回如下的二叉树：

     3
     / \
     9  20
     /  \
     15   7
     */
    /**
     * 后续遍历，最后一个肯定是根节点
     */

    /**
     *
     * @param inorder
     * @param postorder
     * @return
     */
    int[] postorder;
    int[] inorder;
    int index;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.postorder = postorder;
        return buildHelper(0, postorder.length - 1);
    }

    private TreeNode buildHelper(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[index];
        TreeNode node = new TreeNode(val);
        index--;
        int valIndex = map.get(val);
        //先构造右树
        node.right = buildHelper(valIndex + 1, right);
        node.left = buildHelper(left, valIndex - 1);
        return node;
    }
}
