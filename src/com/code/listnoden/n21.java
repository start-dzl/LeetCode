package com.code.listnoden;

import java.util.List;

public class n21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        //关键 升序
        ListNode startNode = new ListNode(-1);
        ListNode node = startNode;
        while (list1 != null && list2 !=null) {

            if(list1.val> list2.val) {
                node.next =  list2;
                list2 = list2.next;

            }else {
                node.next =  list1;
                list1 = list1.next;
            }
            node = node.next;
        }

        if(list1 == null) {
            node.next = list2;
        }

        if(list2 == null) {
            node.next = list1;
        }
        return startNode.next;

    }


}
