package com.code.dp;

public class n509 {

    public int fib(int n) {
        if(n==0|| n==1) {
            return n;
        }
        int lastOne = 1;
        int lastTwo = 0;
        for (int i = 2; i < n; i++) {
            int num = lastOne;
            lastOne = lastOne + lastTwo;
            lastTwo = num;
        }
        return lastOne+ lastTwo;
    }
}
