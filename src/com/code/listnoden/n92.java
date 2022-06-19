package com.code.listnoden;

import java.util.Objects;

public class n92 {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2, node);
        ListNode node2 = new ListNode(1, node1);

        ListNode listNode = reverseBetween(node2, 1, 2);
        System.out.printf("s");
    }

    static ListNode headRight;

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }
        return reverse(head, 1, left, right);
    }

    public static ListNode reverse(ListNode head, int deep, int left, int right) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode reverse = reverse(head.next, deep + 1, left, right);
        if ((deep + 1) == left) {
            head.next = reverse;
            return head;
        }

        if ((deep) == right) {
            headRight = reverse;
            return head;
        }
        if (deep <= right && deep >= left) {
            ListNode next = head.next;
            next.next = head;
            if(deep == left) {
                head.next = headRight;
            }else {
                head.next = null;
            }
            return reverse;
        }

        return head;

    }
}
