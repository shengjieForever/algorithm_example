package com.gsj.www.leetcode;

/**
 * 统计质数
 * 统计所有小于非负整数n的质数的数量
 */
public class CountPrimes {
    public int countPrime(int n){
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count ++;
                for(int j = 2; j*i < n; j++){
                    notPrime[j*i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrime(5));
    }
}
