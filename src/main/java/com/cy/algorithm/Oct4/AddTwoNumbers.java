package com.cy.algorithm.Oct4;

import com.cy.algorithm.entity.ListNode;

/**
 * Created by Yang on 2020/10/6.
 */
public class AddTwoNumbers {

    /**
     * 2. 两数相加
     给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        int calc = 0;
        while(l1 != null && l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + calc;
            int num = val % 10;
            calc = val/10;
            if (node == null) {
                node = new ListNode(num);
                head = node;
            } else {
                node.next = new ListNode(num);
                node = node.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (calc > 0) {
            node.next = new ListNode(calc);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode head = node1;
        node1.next = new ListNode(2);
        node1 = node1.next;
        node1.next = new ListNode(3);
        node1 = node1.next;
        node1.next = new ListNode(4);
        node1 = node1.next;
        System.out.println(node1);
    }
}
