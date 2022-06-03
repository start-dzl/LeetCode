package com.code.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class n51 {

    List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> arrayList = new ArrayList<>();
        this.results = arrayList;
        LinkedList<String> path = new LinkedList<>();
        boolean[][] isRight = new boolean[n][n];

        return results;
    }

    public void solveNQueens(int n, int deep ,LinkedList<String> path,boolean[][] isRight){
        if(path.size() == n) {
            results.add(new ArrayList<>(path));
        }

        for (int i = 0; i < n; i++) {
            
            if(deep == 0&&i==0) {

            }else  if(deep > 0 && i==0) {

            }else if(deep > 0) {

            }else if(deep == 0) {

            }



        }



    }

}
