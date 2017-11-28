package com.orange.framework.arithmetic.sort;

import com.google.common.base.Preconditions;

/**
 * @author : GLGGAG
 * @since : 2017/11/28
 */
public class SortHelper {

    public static void swap(int[] arr,int target,int source){
        preCheckArray(arr);
        int temp=arr[target];
        arr[target]=arr[source];
        arr[source]=temp;
    }

    public static void print(int[] arr){
        preCheckArray(arr);
        for (int z=0;z<arr.length;z++){
            System.out.println(arr[z]);
        }
    }

    public static void preCheckArray(int[] arr){
        Preconditions.checkArgument(arr!=null&&arr.length>=1,"数组不能为空并且长度不能小于1");
    }

}
