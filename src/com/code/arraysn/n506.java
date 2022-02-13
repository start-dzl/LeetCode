package com.code.arraysn;

import java.util.HashMap;
import java.util.Map;

public class n506 {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preNums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            preNums[i + 1] = preNums[i] + num;
        }
        int count = 0;

        for (int i = 0; i < length; i++) {
            int preKey1 = preNums[i];
            for (int j = i; j < length; j++) {
                int preKey2 = preNums[j+1];

                if((preKey2 - preKey1) == k) {
                    count ++;
                }

            }

        }
        return count;

    }


    public int subarraySum1(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        hashMap.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            int sk = sum - k;
            if(hashMap.containsKey(sk)) {
                count += hashMap.get(sk);
            }
            hashMap.put(sum,
                    hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
