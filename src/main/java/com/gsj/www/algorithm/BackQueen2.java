package com.gsj.www.algorithm;

/**
 * @author gongshengjie
 * @Date 8/5/21 3:41 PM
 */
public class BackQueen2 {
    public static void main(String[] args) {
        new BackQueen2().placeQueens(5);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;

    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;

    /**
     * 标记着某一斜线上是否有皇后（左上角 --> 到右下角）
     */
    boolean[] leftTop;

    /**
     * 标记着某一斜线上是否有皇后（右上角 --> 到左下角）
     */
    boolean[] rightTop;

    /**
     * 一共有多少种摆法
     */
    int ways;

    void placeQueens(int n){
        if(n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + ways +"种摆法");
    }

    /**
     * 从row行开始摆放皇后
     * @param row
     */
    private void place(int row) {
    }


}
