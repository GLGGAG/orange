package com.orange.framework.arithmetic.sort;

/**
 * @author : GLGGAG
 * @since : 2017/11/28
 * 快速排序
 *
 *
 *
 * 基本概念:通过一趟排序将待排记录分割成独立两部分，其中一部分记录的元素均比另一部分的元素小
 * 则可分别对这两部分记录继续进行排序，以达到整个序列的有序的目的。
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr={9,1,5,8,3,7,4,6,2};
        quickSort(arr);
    }

    public static void quickSort(int[] arr){
        SortHelper.preCheckArray(arr);
        quickSortRecursion(arr,0,arr.length-1);
        SortHelper.print(arr);
    }
    public static void quickSortRecursion(int[] arr,int f,int h){
        int pivot;
        if (f<h){
            pivot=partition(arr,f,h);
            quickSortRecursion(arr,f,pivot-1);
            quickSortRecursion(arr,pivot+1,h);
        }

    }

    private static int partition(int[] arr, int f, int h) {
        int pivot = arr[f];
        //枢轴选定后永远不变，最终在中间，前小后大
        while (f < h) {
            while (f < h && arr[h] >= pivot) --h;
            //将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivot大的数补上
            arr[f] = arr[h];
            while (f < h && arr[f] <= pivot) ++f;
            //将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivot小的数补上
            arr[h] = arr[f];
        }
        //当left == right，完成一趟快速排序，此时left位相当于空，等待pivot补上
        arr[f] = pivot;
        return f;
    }
}
