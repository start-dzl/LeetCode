package com.code.arraysn;

public class n26 {

    public static void main(String[] args) {
        int[] in = {1, 1, 1,2,2,4,4,4};
        int duplicates = removeDuplicates(in);
        System.out.println(duplicates);
    }

    public static int removeDuplicates(int[] nums) {

        for (int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] >= nums[i + 1]) {
                int mark = i + 1;

                while (mark < (nums.length - 1)) {
                    mark++;
                    if (nums[i] < nums[mark]) {
                        break;
                    }
                }
                if (nums[i] >= nums[mark]) {
                    return i + 1;
                } else {
                    nums[i + 1] = nums[mark];
                    i = mark-1;
                }

            }
        }
        return nums.length;

    }
}
