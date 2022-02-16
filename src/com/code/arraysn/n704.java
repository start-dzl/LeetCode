package com.code.arraysn;

import java.util.HashMap;
import java.util.Map;

public class n704 {

    public int search(int[] nums, int target) {
        int length = nums.length -1;
        int start = 0;
        int end = length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            }else if (target == nums[mid]) {
                end =  mid - 1;
            }else if(target < nums[mid]) {
                end = mid -1;
            }

        }

        if (start >= nums.length || nums[start] != target) {
            return -1;
        }
        return start;

    }


}
