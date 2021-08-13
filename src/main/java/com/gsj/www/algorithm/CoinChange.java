package com.gsj.www.algorithm;

import java.util.Arrays;

/**
 * 贪心算法-零钱兑换
 * @author gongshengjie
 * @Date 8/13/21 3:25 PM
 */
public class CoinChange {
    public static void main(String[] args) {
        Integer[] faces = {25,10,5,1};
        Arrays.sort(faces, (Integer t1, Integer t2) -> t2-t1);

        int money = 66,coins = 0,i = 0;
        while (i < faces.length){
            if (money < faces[i]){
                i ++;
                continue;
            }

            System.out.println(faces[i]);
            money -= faces[i];
            coins ++;
        }
        System.out.println("一共使用了"+coins+"枚硬币");
    }

    static void coinChange(){
        int[] faces = {25,10,5,1};
        Arrays.sort(faces);
        int money = 66,coins = 0;

        for (int i = faces.length - 1; i >= 0; i--){
            if(money < faces[i]){
                continue;
            }

            System.out.println(faces[i]);
            money -= faces[i];
            coins ++;
            i = faces.length;
        }
        System.out.println("一共使用了"+coins+"枚硬币");
    }
}
