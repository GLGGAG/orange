package com.orange.framework.arithmetic.sort;

/**
 * @author : GLGGAG
 * @since : 2017/11/28
 * 希尔排序
 *
 * 在希尔排序算法之前的排序算法时间复杂度基本都是O(n2)，希尔排序算法是突破这个时间复杂度的第一批算法之一
 *
 *
 * @see InsertSort，希尔排序就是对直接插入排序的一个优化。
 * 比如有这么一种情况：对一个无序数组进行从小到大的排序，但是数组的最后一个位置的数是最小的，我们要把它挪到第一个位置，其他位置的都要往后移动，要是这个数组非常大，那么直接插入排序的开销就非常大。
 * 现在有一个array,希尔排序就是设定一个增量incrementNum(0<incrementNum<array.length)。
 * 先从array[0]开始，以incrementNum为增量的进行直接插入排序，直到数组末尾，然后从array[1]开始重复：以incrementNum为增量的进行直接插入排序; 然后从array[1]开始重复......一直到array[n]。
 * 然后取一个小于上一步增量的新的增量（比如设置为incrementNum/2）,对前一个步骤的结果array进行遍历，直接插入排序....
 * 再取小于上一步增量的新的增量，重复进行：遍历，直接插入排序直到新的增量小于1之后再退出循环
 * 步骤1：比如现在有数组{82 ,31 ,29 ,71, 72, 42, 64, 5,110}   第一次取增量设置为array.length/2 = 4    先从82开始以4为增量遍历直到末尾，得到（82,42）
 * 排序得到{42 ,31 ,29 ,71, 72, 82, 64, 5,110}。 然后从第二个数31开始重复上一个步骤，得到（31,64） 排序得到{42 ,31 ,29 ,71, 72, 82, 64, 5,110}.......
 * 以4为增量的遍历完数组之后，得到的结果是{42 ,31,5,71,72,82,64,29,110}
 * 然后重新区增量,这儿设定为incrementNum/2 = 2，对{42 ,31,5,71,72,82,64,29,110}重复步骤1。  完事之后，在取新的增量，重复步骤1。 直到取到的增量小于1，退出循环。
 *
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr={9,1,5,8,3,7,4,6,2};
        shellSort(arr);

    }

    /**
     *
     * 复杂度分析：时间复杂度为O(n3/2)
     */
    public static void shellSort(int[] arr) {
        SortHelper.preCheckArray(arr);
        //增量
        int incrementNum = arr.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < arr.length; i++) {
                //进行插入排序
                for (int j = i; j < arr.length - incrementNum; j = j + incrementNum) {
                    if (arr[j] > arr[j + incrementNum]) {
                        SortHelper.swap(arr,j,j+incrementNum);
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }
        SortHelper.print(arr);
    }
}
