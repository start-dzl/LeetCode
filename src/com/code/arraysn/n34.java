package com.code.arraysn;

public class n34 {

    public int[] searchRange(int[] nums, int target) {
        int right = 0;
        int left = nums.length -1;

        while (right <= left) {
            int mid = right + (left - right) / 2;
            if(nums[mid] == target) {
                int rendRight = mid;
                int rendLeft = mid;

                while (rendRight <= left) {
                    if( rendRight -1 > -1 && nums[rendRight -1] == target) {
                        rendRight --;
                    }else {
                        break;
                    }
                }

                while (rendLeft >= right) {
                    if(rendLeft+ 1< nums.length && nums[rendLeft+ 1] == target) {
                        rendLeft ++;
                    }else {
                        break;
                    }
                }
                return new int[]{rendRight, rendLeft};
            }else if(nums[mid] < target) {
                right = mid + 1;
            }else if (nums[mid] > target){
                left = mid -1;
            }
        }
        int[] ints = {-1, -1};
        return ints;


    }

}
