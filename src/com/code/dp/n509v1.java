package com.code.dp;

public class n509v1 {

    public int fib(int n) {
        if(n == 1|| n == 0) {
            return n;
        }

        var num = fib(n - 1)+ fib(n-2);
        return num;

    }

    public static void main(String[] args) {
        System.out.println(fib1(4));
    }

    public static int fib1(int n) {
        if(n == 1|| n == 0) {
            return n;
        }
        var lastOne = 1;
        var lastTwe = 0;
        var thisone = 0;
        for (int i = 2; i <=n; i++) {
            thisone = lastOne + lastTwe;
            lastTwe = lastOne;
            lastOne = thisone;

        }

        return thisone;

    }
}
