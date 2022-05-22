package com.code.listnoden;

import java.util.Objects;
import java.util.PriorityQueue;

public class n23v2 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        for (ListNode listNode : lists) {
            if(listNode!=null){
                priorityQueue.add(listNode);
            }

        }
        ListNode node = new ListNode();
        ListNode next = node;
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            next.next = poll ;
            if(poll.next != null) {
                priorityQueue.add(poll.next);
            }
            next = next.next;
        }
        return node.next;

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
