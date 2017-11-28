package com.orange.framework.arithmetic.sort;

/**
 * @author : GLGGAG
 * @since : 2017/11/28
 *
 * 简单选择排序算法
 *
 *
 * 基本概念：每一趟在n-i+1(i=1,2,3.....n-1)个记录选取关键字最小的记录作为有序序列的第i个记录
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int[] arr={9,1,5,8,3,7,4,6,2};
        selectSort(arr);

    }

    /**
     *对于arr={9,1,5,8,3,7,4,6,2}
     * 当i=0时，arr[i]=9  min=0，然后与j=1-->arr[j]=1比较，因为j=1时最小 因此min=1, 最终交换了min=1和i=0的值
     * 比较了arr.length-1次  只交换一次
     *
     *
     * 复杂度分析：
     * 从过程来看，最大的特点就是交换移动的次数相当少，仅有一次，因此节约的相应的时间，总的时间复杂度依然为0（n2）与冒泡排序相同，
     * 但是简单选择排序的性能还是略优于冒泡排序
     *
     */
    private static void selectSort(int[] arr){
        SortHelper.preCheckArray(arr);
        int i,j,min;
        int len=arr.length;

        for (i=0;i<len;i++){
            min=i;//将当前下标定义为最小值下标
            for (j=i+1;j<len;j++){
                if (arr[min]>arr[j]){//如果有小于当前值得则交换下标
                    min=j;
                }
            }
            if (i!=min){//如果min不等于i  说明找到最小值 交换
                SortHelper.swap(arr,i,min);
            }
        }
        SortHelper.print(arr);
    }




}
