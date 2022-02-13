package com.code.arraysn;

public class n303 {

    private int[] preNums;

    public n303(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            preNums[i+1] = preNums[i] + num;
        }

    }

    public int sumRange(int left, int right) {

        return preNums[right+ 1] - preNums[left];
    }

}
