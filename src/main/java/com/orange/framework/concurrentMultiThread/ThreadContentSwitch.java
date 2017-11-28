package com.orange.framework.concurrentMultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author : GLGGAG
 * @since : 2017/11/24
 * 线程上下文切换研究
 */
public class ThreadContentSwitch {

    public static void main(String[ ] args) throws InterruptedException {
        concurrency() ;
        serial() ;
    }

    /**
     *下面的代码演示串行和并发执行并累加操作的时间， 请分析： 下面的代码并发执行一定比串行执行快吗？
     */
        private static final long count = 10000l;
        private static void concurrency() throws InterruptedException {
            long start = System. currentTimeMillis() ;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = 0;
                    for (long i = 0; i < count; i++) {
                        a += 5;
                    }
                }
            } ) ;
            thread. start() ;
            int b = 0;
            for (long i = 0; i < count; i++) {
                b--;
            }
            long time = System. currentTimeMillis() - start;
            thread. join() ;
            System. out. println("concurrency : " + time+"ms, b="+b) ;
        }
        private static void serial() {
            long start = System. currentTimeMillis() ;
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
            int b = 0;
            for (long i = 0; i < count; i++) {
                b--;
            }
            long time = System. currentTimeMillis() - start;
            System. out. println("serial: " + time+"ms, b="+b+", a="+a) ;
        }
    /**
     * concurrency : 6ms, b=-10000  serial: 1ms, b=-10000, a=50000  结果显示不一定，因为线程切换存在一定的代价，当运算次量底时，多线程并不见得会比单线程更快更好
     *
     */





}


