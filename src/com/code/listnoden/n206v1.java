package com.code.listnoden;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class n206v1 {
    public ListNode reverseList(ListNode head) {
        if(Objects.isNull(head)) {
            return null;
        }

        LinkedList<ListNode> linkedList = new LinkedList<>();
        while (!Objects.isNull(head)){
            linkedList.add(head);
            head = head.next;
        }
        ListNode dump = new ListNode();
        ListNode next = dump;

        for (int i = linkedList.size() -1; i >= 0 ; i--) {
            ListNode ln = linkedList.get(i);
            next.next = ln;
            next.next.next = null;
            next = next.next;
        }
        return dump.next;
    }

    public ListNode reverseList1(ListNode head) {
        if(Objects.isNull(head)) {
            return null;
        }
       return reverse(head);
    }

    public ListNode reverse(ListNode head) {

        if(Objects.isNull(head)|| Objects.isNull(head.next)) {
            return head;
        }
        ListNode reverse = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return  reverse;


    }


}
