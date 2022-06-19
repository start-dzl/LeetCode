package com.code.listnoden;

import java.util.Objects;

public class n86 {

    public ListNode partition(ListNode head, int x) {

        if(Objects.isNull(head)) {
            return null;
        }

        ListNode dumpL = new ListNode();
        ListNode nextL = dumpL;

        ListNode dumpR = new ListNode();
        ListNode nextR = dumpR;

        while (!Objects.isNull(head)) {
            if(head.val<x) {
                nextL.next = head;
                nextL = nextL.next;

            }else if(head.val>=x){
                nextR.next = head;
                nextR = nextR.next;
            }
            head = head.next;
        }
        nextL.next = null;
        nextR.next = null;

        if(Objects.isNull(dumpL.next)) {
                return dumpR.next;
        }

        if(Objects.isNull(dumpR.next)) {
            return dumpL.next;
        }
        nextL.next = dumpR.next;

        return dumpL.next;


    }


}
