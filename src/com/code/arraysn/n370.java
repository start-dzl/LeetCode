package com.code.arraysn;

import com.code.listnoden.n21;

import java.util.HashMap;
import java.util.Map;

public class n370 {


    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ints = new int[length];
        Diff diff = new Diff(ints);
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];
            diff.changeArray(startIndex, endIndex,inc);
        }

        return diff.getArray();

    }


    public class Diff {
        private int[] preNums;
        public Diff(int[] nums) {
            preNums = new int[nums.length];
            preNums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                preNums[i] = num - nums[i - 1];
            }

        }

        public void changeArray(int startIndex, int endIndex, int inc) {
            preNums[startIndex] += inc;
            if(preNums.length > endIndex+ 1) {
                preNums[endIndex+ 1] -= inc;
            }

        }

        public int[] getArray() {
            int[] resultNums = new int[preNums.length];
            resultNums[0] = preNums[0];
            for (int i = 1; i < preNums.length; i++) {
                resultNums[i] = preNums[i] + resultNums[i - 1];
            }
            return resultNums;

        }

    }
}
