package com.code.doublecs;

import com.code.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class n116v1 {
    public Node connect(Node root) {
        if(Objects.isNull(root)){
            return root;
        }
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()){
            int size = queue.size();
            Node start = null;
            for (int i = 0; i < size; i++) {
                Node next = queue.poll();
                if(!Objects.isNull(next.left)) {
                    queue.add(next.left);
                }
                if(!Objects.isNull(next.right)) {
                    queue.add(next.right);
                }
                if(Objects.isNull(start)) {
                    start = next;
                }else {
                    start.next = next;
                    start = next;
                }

            }

        }

        return root;
    }
}
