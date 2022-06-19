package com.code.listnoden;

import java.util.Objects;

public class n21V2 {
    public static void main(String[] args) {
        n21V2 n21V2 = new n21V2();
        n21V2.mergeTwoLists(null,null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode headPre = new ListNode();
        ListNode next = headPre;

        while (!Objects.isNull(list1)|| !Objects.isNull(list2)){
            if(Objects.isNull(list1)) {
                next.next = list2;
                break;
            }

            if(Objects.isNull(list2)) {
                next.next = list1;
                break;
            }

            if(list1.val <= list2.val){
                next.next = list1;
                list1 = list1.next;
                next = next.next;
            }else {
                next.next = list2;
                list2 = list2.next;
                next = next.next;
            }
        }
        return headPre.next;
    }


}
