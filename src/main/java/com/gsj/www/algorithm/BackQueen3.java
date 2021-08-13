package com.gsj.www.algorithm;

/**
 * 八皇后排列算法-汇编语言的写法
 * @author gongshengjie
 * @Date 8/5/21 3:41 PM
 */
public class BackQueen3 {
    public static void main(String[] args) {
        new BackQueen3().place8Queens();
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;

    /**
     * 标记着某一列是否有皇后
     */
    byte cols;

    /**
     * 标记着某一斜线上是否有皇后（左上角 --> 到右下角）
     */
    short leftTop;

    /**
     * 标记着某一斜线上是否有皇后（右上角 --> 到左下角）
     */
    short rightTop;

    /**
     * 一共有多少种摆法
     */
    int ways;

    void place8Queens(){
        queens = new int[8];
        place(0);
        System.out.println("八皇后一共有" + ways +"种摆法");
    }

    /**
     * 从row行开始摆放皇后
     * @param row
     */
    void place(int row) {
        if(row == 8){
            ways ++;
            show();
            return;
        }

        for (int col = 0; col < 8; col ++){
            int cv = 1 << col;
            if((cols & cv) != 0) continue;

            int lv = 1 << (row - col + 8 - 1);
            if((leftTop & lv) != 0) continue;

            int rv = 1 << (row + col);
            if((rightTop & rv) != 0) continue;

            queens[row] = col;
            //"｜="和"&=" 的计算方式类似"+="，即做完两字段"|"或者"&"操作后在赋值给前者
            cols |= cv;
            leftTop |= lv;
            rightTop |= rv;
            place(row + 1);
            //"&= ~" 就是把~后面的数值取反,然后和&=前的变量做与操作
            cols &= ~cv;
            leftTop &= ~lv;
            rightTop &= ~rv;
        }
    }

    void show(){
        for (int row = 0; row < 8; row ++){
            for (int col = 0; col < 8; col ++){
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
