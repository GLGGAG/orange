package com.orange.framework.arithmetic.search;


import com.orange.framework.arithmetic.sort.SortHelper;

/**
 * 暴力查找法 : 将要查找的数据整体遍历 ，与期待值做比较
 * 也叫顺序查找  沿着某一端的方向遍历
 */
public class ViolenceSearch {


    public static void main(String[] args) {
        int[]  a={9,1,5,8,3,7,4,6,2};
        System.out.println(violenceFirst(a,10));

    }


    /**
     * 整体遍历带查找的数组数据  找到返回当前值的所在的数组角标，否则返回-1
     *
     * 假设数组元素为n个
     * 那么需要进行遍历n个操作   同时进行比较n次   因此时间复杂度的O(2n)
     *
     * 思考是否有更好的方案？
     */
    public static int violenceFirst(int[] arr,int target){
        SortHelper.preCheckArray(arr);
        int i;
        for (i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return  i;
            }
        }
        return  -1;
    }









}
