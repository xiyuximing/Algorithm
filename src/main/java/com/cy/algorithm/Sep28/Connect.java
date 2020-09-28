package com.cy.algorithm.Sep28;

import com.cy.algorithm.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2020/9/28.
 */
public class Connect {

    /**
     * 117. 填充每个节点的下一个右侧节点指针 II
     给定一个二叉树

     struct Node {
     int val;
     Node *left;
     Node *right;
     Node *next;
     }
     填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

     初始状态下，所有 next 指针都被设置为 NULL。



     进阶：

     你只能使用常量级额外空间。
     使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。


     示例：



     输入：root = [1,2,3,4,5,null,7]
     输出：[1,#,2,3,#,4,5,7,#]
     解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     */

//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            Node node = null;
//            Node next = null;
//            for (int i = 0; i < n; i++) {
//                next = queue.poll();
//
//                if (next.left != null) {
//                    queue.offer(next.left);
//                }
//                if (next.right != null) {
//                    queue.offer(next.right);
//                }
//                if ( i > 0) {
//                    node.next = next;
//                }
//                node = next;
//            }
//        }
//        return root;
//    }

    Node last;
    Node nextStart;
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node node = start; node != null; node = node.next) {
                 if (node.left != null) {
                    next(node.left);
                 }
                 if (node.right != null) {
                    next(node.right);
                 }
            }
            start = nextStart;
        }

        return root;
    }

    private void next(Node node) {
        if (last != null) {
            last.next = node;
        }
        if (nextStart == null) {
            nextStart = node;
        }
        last = node;
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node2.left = node5;
        node3.right = node7;
        root = connect.connect(root);
        System.out.print(root);
     }
}
