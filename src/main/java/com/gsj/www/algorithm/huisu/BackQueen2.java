package com.gsj.www.algorithm.huisu;

/**
 * 皇后摆放算法
 * @author gongshengjie
 * @Date 8/5/21 3:41 PM
 */
public class BackQueen2 {
    public static void main(String[] args) {
        new BackQueen2().placeQueens(4);
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
    void place(int row) {
        if(row == cols.length){
            ways ++;
            show();
            return;
        }

        //TODO 这个写法暂时还有点问题
        for (int col = 0; col < cols.length; col ++){
            if(cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if(leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if(rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[row] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show(){
        for (int row = 0; row < cols.length; row ++){
            for (int col = 0; col < cols.length; col ++){
                if(queens[row] == col){
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("========================");
    }
}
