package com.gsj.www.leetcode;

/**
 * 斐波那契数
 * eg：0 1 1 2 3 5 8 13 21 ...
 */
public class Fibonacci {
    public static int fib(int n){
        if(n <= 1) return n;
        return fib(n-1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
