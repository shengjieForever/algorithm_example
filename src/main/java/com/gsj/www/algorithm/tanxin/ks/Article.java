package com.gsj.www.algorithm.tanxin.ks;

/**
 * 海盗装金银的包
 * @author gongshengjie
 * @Date 8/13/21 5:08 PM
 */
public class Article {
    /**
     * 重量
     */
    public int weight;
    /**
     * 价值
     */
    public int value;
    /**
     * 单位价值密度
     */
    public double valueDensity;

    public Article(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.valueDensity = value * 1.0 / weight;
    }

    @Override
    public String toString() {
        return "Article{" +
                "weight=" + weight +
                ", value=" + value +
                ", valueDensity=" + valueDensity +
                '}';
    }
}
