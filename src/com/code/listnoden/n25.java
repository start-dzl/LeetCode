package com.code.listnoden;

import java.util.Objects;

public class n25 {

    ListNode headRight;

    int hdeep;

    public ListNode reverseKGroup(ListNode head, int k) {
        if(Objects.isNull(head)) {
            return head;
        }
        return reverse(head, 1, k);
    }

    public  ListNode reverse(ListNode head, int deep, int k) {
        if (Objects.isNull(head.next)) {
            hdeep = deep;
            return head;
        }
        ListNode reverse = reverse(head.next, deep + 1, k);
        int i = hdeep / k;
        int left;
        int right;
        if(i*k < deep) {
            left = -1;
            right = -1;
        }else {
            int m = deep / k;
            left = m * k;
            right = left + k;
        }
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


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
