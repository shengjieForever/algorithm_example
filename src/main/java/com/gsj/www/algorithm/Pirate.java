package com.gsj.www.algorithm;

import java.util.Arrays;

/**
 * 贪心算法-海盗问题
 * @author gongshengjie
 * @Date 8/13/21 2:51 PM
 */
public class Pirate {
    public static void main(String[] args) {
        int[] weights = {12,3,5,1,10,9,6};
        Arrays.sort(weights);
        int capacity = 30, weight = 0, count = 0;

        for (int i = 0; i < weights.length && weight < capacity; i ++){
            int newWeight = weight + weights[i];
            if(newWeight <= capacity){
                weight = newWeight;
                count ++;
                System.out.println(weights[i]);
            }
        }
        System.out.println("一共选了"+count+"件古董");
    }
}
