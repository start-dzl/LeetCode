package com.code.arraysn;

public class n27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast< nums.length) {
            if(nums[fast] == val) {
                fast++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
