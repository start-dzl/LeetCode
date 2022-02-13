package com.code.arraysn;

import java.util.HashMap;
import java.util.Map;

public class n48 {
    // 将二维矩阵原地顺时针旋转 90 度
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[] ints = matrix[i];
            int m = ints.length;
            for (int j = i; j < m; j++) {
                int mc = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = mc;
            }

        }


        for (int i = 0; i < n; i++) {
            int[] ints = matrix[i];
            int m = ints.length;
            int length = m/2;
            for (int j = 0; j < length; j++) {
                int mc = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = mc;

            }
        }
    }
}
