package com.code.tu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class n797 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        runall(graph, 0, new LinkedList<>());
        return res;

    }

    private void runall(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);
        int[] ints = graph[s];
        int length = graph.length;
        if(length == (s + 1)) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            runall(graph, anInt, path);
        }
        path.removeLast();
    }
}
