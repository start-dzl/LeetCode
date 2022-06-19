package com.code.listnoden;

import java.util.LinkedList;
import java.util.Objects;

public class n234 {
    public boolean isPalindrome(ListNode head) {
        if(Objects.isNull(head)) {
            return false;
        }
        if(Objects.isNull(head.next)){
            return true;
        }
        ListNode head1 = head;
        ListNode head2 = head;
        int deep = -1;
        LinkedList<ListNode> ll = new LinkedList<>();
        while (!Objects.isNull(head2)){
            ListNode next2 =  head2.next;
            ll.add(head1);
            if(Objects.isNull(next2)) {
                head1 = head1.next;
                break;
            }else {
                next2 = next2.next;
            }
            head1 = head1.next;
            deep++;
            head2 = next2;
        }

        while (!Objects.isNull(head1)){
            ListNode node = ll.get(deep);
            if(head1.val != node.val) {
                return false;
            }
            head1 = head1.next;
            deep--;
        }

        return true;
    }


}
