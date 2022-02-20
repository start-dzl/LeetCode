package com.code.listnoden;

public class n206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        if(head == null|| head.next == null){
            return head;
        }

        ListNode reverseList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseList;

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
