package com.orange.thread;

/**
 * @author:GLGGAG
 * @Date:2017/10/31
 * @Description:
 */
public class OutputDemo extends Thread {
    private SourceDemo  s;

    public OutputDemo(SourceDemo  demo){
        this.s=demo;
    }
    @Override
    public void run() {
        while (true){
            synchronized (s){
                if (!s.flag){
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(s.sex+"===="+s.name);
                s.flag=false;
                s.notify();
            }
        }
    }
}
