package com.code.arraysn;

public class n167 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                if ((target - numbers[i] == numbers[j])) {
                    int[] ints = {i + 1, j + 1};
                    return ints;
                }

            }

        }
        return null;
    }

    public int[] twoSumV(int[] numbers, int target) {
        int start  = 0;
        int end  = numbers.length - 1;

        while (start< end){
            int sum = numbers[start] + numbers[end];

            if(sum == target) {
                int[] ints = {start+ 1, end + 1};
                return ints;
            }else if(sum < target) {
                start++;
            }else {
                end--;
            }

        }

        return null;

    }


}
