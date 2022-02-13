package com.code.listnoden;

import java.util.PriorityQueue;

public class n23 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        ListNode fake = new ListNode();
        ListNode node =  fake;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));

        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()){
            node.next = pq.poll();
            if(node.next.next != null) {
                pq.add(node.next.next);
            }
            node = node.next;
        }
        return fake.next;

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
