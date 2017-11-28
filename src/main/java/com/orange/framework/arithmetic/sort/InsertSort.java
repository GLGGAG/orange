package com.orange.framework.arithmetic.sort;

/**
 * @author : GLGGAG
 * @since : 2017/11/28
 *
 *
 * 直接插入排序
 *
 * 基本概念:将一个记录插入到已经排好序的的有序表中，从而得到一个新的，记录数增1的有序表
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr={9,1,5,8,3,7,4,6,2};
        insertSort(arr);

    }

    /**
     *先将第一个元素和第二个元素排序成一个有序数列以后
     * 在将第三个元素插入到已经排好序的有序数列中，以此类推下去
     *
     *
     * 复杂度分析：0(N2)时间复杂度，  直接插入排序算法比冒泡和选择排序的性能要好一些
     *
     *
     */
    public  static  void insertSort(int[] arr){
        SortHelper.preCheckArray(arr);
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = temp;
        }
        SortHelper.print(arr);
    }
}
