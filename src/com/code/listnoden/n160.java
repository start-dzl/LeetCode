package com.code.listnoden;

public class n160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }

        ListNode guardA = headA;
        ListNode guardB =  headB;

        while (guardA!=null) {
            guardB = headB;
            while (guardB !=null) {
                if (guardA==guardB){
                    return guardA;
                }else {
                    guardB = guardB.next;
                }
            }

            guardA = guardA.next;

        }

        return null;

    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode guardA = headA;
        ListNode guardB =  headB;

        while (guardA != guardB) {
            if(guardA == null) {
                guardA = headB;
            }else {
                guardA = guardA.next;
            }

            if (guardB == null) {
                guardB = headA;
            }else {
                guardB = guardB.next;
            }
        }

        return guardA;
    }
}
