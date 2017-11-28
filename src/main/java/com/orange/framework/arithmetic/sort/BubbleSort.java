package com.orange.framework.arithmetic.sort;

/**
 * @author : GLGGAG
 * @since : 2017/11/27
 *
 * 冒泡排序算法
 *
 * 基本概念：两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为止
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        //
        int[] arr={1,2,8,9,5,6,3,9,0};
        //bubbleSortFirst(arr);
        //bubbleSortSecond(arr);
        bubbleSortThird(arr);

    }

    /**
     * 第一种实现冒泡排序的实现
     * 严格意义上来讲，不算是标准的冒泡排序算法，因为它不满足"两两比较相邻记录"的冒泡排序思想，
     * 它更应该是最最简单的交换排序而已
     *
     *
     * 思路：让每一个值，都和它后面的每一个值比较，如果大则交换，因此遍历循环一次后第一位一定是最小的值
     *
     *
     * 思考：假如数组
     * int[]  a={9,1,5,8,3,7,4,6,2}
     * 第1次遍历交换后
     * a={1,9,5,8,3,7,4,6,2}
     * 第2次遍历交换后
     * a={1,2,9,8,5,7,4,6,3}
     * 由此发现，当第二次遍历交换后，3排在了最后面，因此我们得知，当前算法只对当前关键字排序，对其余关键字并无任何帮助
     *
     *
     */
    public static void bubbleSortFirst(int[] arr){
        SortHelper.preCheckArray(arr);
        int i,j;
        int len=arr.length;
        for (i=0;i<len;i++){
            for (j=i+1;j<len;j++){
                if (arr[i]>arr[j]){
                    SortHelper.swap(arr,i,j);
                }
            }
        }
       SortHelper.print(arr);
    }

    /**
     * 第二种实现冒泡排序的实现
     *这也是正宗的冒泡算法，与第一种实现的区别在于，内循环是反向遍历
     *
     * 思路：从后往前排序，两两相邻比较，如果小，那么就交换到前面，犹如气泡一样慢慢的冒了上来
     * 因此叫做冒泡算法
     *
     * 那么，这种实现的冒泡算法是否还能够优化呢？
     * int a={2,1,3,4,5,6,7,8,9}
     * 加入这样的一个数组
     * 只需要交换2,1以外，其他都不在需要交换，但是我们的算法依然会不断的循环遍历
     *
     * 当i=1时，交换了2,1元素
     * a={1,2,3,4,5,6,7,8,9}
     * 数组a已经变成了有序排序数据，当i=2时，再次遍历就不会有数据交换，也就是所有元素都是有序了，因此剩下的不在需要遍历比较交换
     *  bubbleSortThird()
     */
    public static void bubbleSortSecond(int[] arr){
        SortHelper.preCheckArray(arr);
        int i,j;
        int len=arr.length;
        for (i=0;i<len;i++){
            for (j=len-1;j>=i;j--){//j是从后往前遍历
                if (arr[j-1]>arr[j]){//注意前者大于后者（这里与第一种实现算法有差异）
                    SortHelper.swap(arr,j-1,j);
                }
            }
        }
       SortHelper.print(arr);
    }

    public static void bubbleSortThird(int[] arr){
        SortHelper.preCheckArray(arr);
        int i,j;
        int len=arr.length;
        boolean flag=true;//用于作为标记
        for ( i=0; i<len && flag; i++ ){
            flag=false;
            for (j=len-1;j>=i;j--){
                if (arr[j-1]>arr[j]){
                    SortHelper.swap(arr,j-1,j);
                    flag=true;//如果有数据交换  则flag为true
                }
            }
        }
        SortHelper.print(arr);
    }


    /**
     *冒泡排序算法复杂度分析
     *
     *  时间复杂度:
     *      当最好的情况，也就是要排序的表本身就是有序的，那么我们比较次数，根据最后改进的代码，
     *  可以推断出就是n-1次的比较，没有次数交换  因此时间复杂度为0（n）
     *      当最坏的情况，也就是全部数据都需要比较交换，此时需要
     *      N                               n(n-1)
     *      E（i-1）=1+2+3+........(n-1)=-------------次，并作等数量级的记录移动
     *      i=2                              2
     *      因此总的时间复杂度为0(n2)
     *
     */

}
