package com.orange.support.aritchmetic;

import java.util.Arrays;

/**
 * @author : GLGGAG
 * @since : 2017/11/22
 */
public class Demo {

    public static void getMaxSnest(int[][] envelopse){

        //对数组排序，只按照一维升序排
        int[][] temp={{0,0}};
        for(int i=0;i<envelopse.length;i++){
            for (int j=i+1;j<envelopse.length;j++){

                if(envelopse[i][0]>envelopse[j][0]){
                    temp[0][0]=envelopse[i][0];
                    temp[0][1]=envelopse[i][1];

                    envelopse[i][0] = envelopse[j][0];
                    envelopse[i][1] = envelopse[j][1];

                    envelopse[j][0] = temp[0][0];
                    envelopse[j][1] = temp[0][1];
                }
            }
        }

        for (int i = 0; i < envelopse.length; i++) {
            System.out.println(envelopse[i][0]+","+envelopse[i][1]);
        }

        //最大上升子序列
        int[] len = new int[envelopse.length];

        for(int i=0;i<envelopse.length;i++){
            len[i]=1;
            for(int j=0;j<i;j++){
                if(envelopse[i][0]>envelopse[j][0]&&envelopse[i][1]>envelopse[j][1]&&len[j]+1>len[i]){
                    len[i]=len[j]+1;
                }
            }
        }
        Arrays.sort(len);
        System.out.println("最大嵌套数量："+len[len.length-1]);

    }



}
