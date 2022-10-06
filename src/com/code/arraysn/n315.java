package com.code.arraysn;

public class n315 {

    int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end-start)/2;

        sort(nums, start, mid);

        sort(nums, mid+1, end);

        marge(nums, start, end, mid);

    }

    private void marge(int[] nums, int start, int end, int mid) {

        for (int i = start; i <=end; i++) {
            temp[i] = nums[i];
        }
        int s = start ;
        int m = mid +1;
        for (int i = start; i <= end ; i++) {
            if(s == (mid+1)) {
                nums[i] = temp[m++];
            }else if(m == (end+1)) {
                nums[i] = temp[s++];
            }
            else if(temp[s] < temp[m]) {
                nums[i] = temp[s++];
            }else {
                nums[i] = temp[m++];
            }

        }

    }

}
