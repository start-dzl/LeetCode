package com.code.arraysn;

public class n912 {

    int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        marge(nums, start, end, mid);

    }

    private void marge(int[] nums, int start, int end, int mid) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int startMark = start;
        int midMark = mid + 1;

        for (int i = start; i <= end; i++) {

            if(i == (mid+1)) {
                nums[i] = temp[midMark++];
            }else if(midMark == (end+1)) {
                nums[i] = temp[startMark++];;
            } else if (temp[startMark] > temp[midMark]) {
                nums[i] = temp[midMark++];
            } else {
                nums[i] = temp[startMark++];
            }

        }


    }

}
