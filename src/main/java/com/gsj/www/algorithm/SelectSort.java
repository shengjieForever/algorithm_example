package com.gsj.www.algorithm;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 选择排序
 */
public class SelectSort {

    public static int[] selectionSort(int data[]){
        int min;
        for(int i=0;i<data.length;i++){
            min = i;
            // 这个for循环是为了找出最小的值
            for (int j = i+1; j < data.length; j++) {
                if(data[min]>data[j]){
                    min = j;
                }
            }
            /** 如果第一个取出的元素不是最小值，就进行交换
             * 意思就是：如果取出的元素就是最小值，那么就没有必要进行交换了 		   */
            if(min != i){
                // 进行交换
                exc(data, i, min);
            }
        }
        return data;
    }

    /**
     * 交换a数组中i和j的位置
     * @param data 需要交换的数组
     * @param i 位置
     * @param j 位置
     */
    public static void exc(int data[],int i,int j){
        // 当他们相等的时候就没必要进行交换
        if(data[i] != data[j]){
            data[i] ^= data[j];
            data[j] ^= data[i];
            data[i] ^= data[j];
        }
    }

//    static class Person{
//        private String id;
//        private String name;
//
//        public Person() {
//
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Person(String id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }
    public static void main(String[] args) {
        int[] data = {2,6,7,1,4,3};
        exc(data, 0, 0);
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }


//        List<Person> list = new ArrayList<Person>();
//        Map<String,Person> map = new HashMap<String,Person>();
//        Person person1 = new Person();
//        Person person2 = new Person();
//        Person person3 = new Person();
//        person1.setName("xiaobai");
//        person2.setName("xiaohua");
//        person3.setName("xiaohong");
//        list.add(person1);
//        list.add(person2);
//        list.add(person3);
//        map.put("1",person1);
//        map.put("2",person2);
//        map.put("3",person3);
//        person1.setName("小白");
//        person2.setName("小花");
//        person3.setName("小红");
//        System.out.println("--"+list.get(1).getName());
//        System.out.println("=="+map.get("2").getName());
    }
}
