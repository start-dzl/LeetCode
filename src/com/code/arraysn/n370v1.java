package com.code.arraysn;

public class n370v1 {

    public int[] getModifiedArray(int length, int[][] updates) {


        int[] pre = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            if(start > (length -1 )) {
                continue;
            }else {
                pre[start] = pre[start] + inc;
            }

            if(end >= (length -1 )) {
                continue;
            }else {
                pre[end + 1] = pre[end + 1] - inc;
            }
        }
       int[] nums = new int[length];
        nums[0] = pre[0];
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i-1] + pre[i];
        }

        return nums;

    }
}
