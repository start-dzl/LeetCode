package com.code.arraysn;

public class n304 {

    private int[][] preNums;

    public n304(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;

        preNums = new int[m + 1][n + 1];

        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            for (int j = 0; j < ints.length; j++) {
                preNums[i+ 1][j+1] = preNums[i][j+1] + preNums[i+ 1][j] - preNums[i][j] + matrix[i][j];
            }
            
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNums[row2+1][col2+1] - preNums[row1][col2+1] - preNums[row2+1][col1] + preNums[row1][col1];
    }

}
