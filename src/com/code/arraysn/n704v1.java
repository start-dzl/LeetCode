package com.code.arraysn;

public class n704v1 {

    public static int search(int[] nums, int target) {
        int left = nums.length -1;
        int right = 0;

        while (right <= left){

            int mid = right + (left - right) / 2;

            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                right = mid + 1;
            }else if (nums[mid] > target){
                left = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 3,5,9, 14};

        int i = search(ints, 9);
        System.out.printf(i+ "");

    }
}
