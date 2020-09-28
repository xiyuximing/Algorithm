package com.cy.algorithm.Sep24;

import com.cy.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2020/9/24.
 */
public class FindMode {
    /**
     * 501. 二叉搜索树中的众数
     给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

     假定 BST 有如下定义：

     结点左子树中所含结点的值小于等于当前结点的值
     结点右子树中所含结点的值大于等于当前结点的值
     左子树和右子树都是二叉搜索树
     例如：
     给定 BST [1,null,2,2],

     1
     \
     2
     /
     2
     返回[2].

     提示：如果众数超过1个，不需考虑输出顺序

     进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     */

    /**
     * 采用中序遍历，及左节点-》根节点-》右节点方式
     */
    int count = 0, maxCount = 0, curVal;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (curVal == node.val) {
            count++;
        } else {
            count = 1;
            curVal = node.val;
        }
        if (count == maxCount) {
            list.add(node.val);
        } else if (count > maxCount) {
            list.clear();
            list.add(node.val);
            maxCount = count;
        }
        dfs(node.right);
    }
}
