package com.code.arraysn;

public class n283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast< nums.length) {
            if(nums[fast] == 0) {
                fast++;
            }else {
                int num = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = num;
                slow++;
                fast++;
            }
        }

    }
}
