package com.code.arraysn;

public class n48v1 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = i +1; j < width; j++) {
                if(j!=i) {
                    int num = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i]= num;
                }
            }

        }
        for (int i = 0; i < length; i++) {
            int start = 0;  int end = width -1;
            while (start<end){
                int num = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end]= num;
                start++;
                end--;
            }
        }
    }



}
