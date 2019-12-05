package com.gsj.www.algorithm;

/**
 * 快速排序
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 *           然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 排序流程：
 *         (1)首先设定一个分界值，通过该分界值将数据分为左右2部分。
 *         (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。
 *         (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取1个分界值，将该部分数据分为2部分，同样在左边设置较小值，右边设置较大值。右侧的数组数据也可以做类似处理。
 *         (4)重复上述步骤。通过递归将左侧部分排好序后，再递归排好右侧部分的数据。当左右各部分数据排序完成后，整个数组的排序也就完成了。
 * @author holy
 */
public class QuickSort {
    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
        int len = arr.length-1;
        arr=qsort(arr,0,len);
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }
}
