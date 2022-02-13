package com.code.listnoden;

public class n19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode guard1, guard2 ;
        guard1 = dummy;
        guard2 = dummy;
        for (int i = 0; i < n+1; i++) {
            guard1 = guard1.next;
        }
        while (guard1 != null) {
            guard1 = guard1.next;
            guard2 = guard2.next;
        }
        guard2.next = guard2.next.next;
        return dummy.next;
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
