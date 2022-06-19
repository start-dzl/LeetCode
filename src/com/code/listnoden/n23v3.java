package com.code.listnoden;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class n23v3 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(Objects.isNull(lists) || lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                (s1,s2)-> {
                    return s1.val - s2.val;
                }
        );
        for (ListNode node : lists) {
            if(!Objects.isNull(node)) {
                priorityQueue.add(node);
            }
        }

        ListNode dump = new ListNode();
        ListNode node = dump;

        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            if(!Objects.isNull(poll.next)) {
                priorityQueue.add(poll.next);
            }
            node.next = poll;
            node = node.next;
        }

        return dump.next;

    }
}
