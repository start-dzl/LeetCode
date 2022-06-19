package com.code.listnoden;

public class n21v1 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode next = head;
        while (list1 != null || list2 != null){
            if(list1 == null) {
                next.next = list2;
                next = next.next;
                break;
            }

            if(list2 == null) {
                next.next = list1;
                next = next.next;
                break;
            }

            if(list1.val >= list2.val) {
                next.next = list2;
                next = next.next;
                list2 = list2.next;
            }else {
                next.next = list1;
                next = next.next;
                list1 = list1.next;
            }

        }
        return head.next;

    }


}
