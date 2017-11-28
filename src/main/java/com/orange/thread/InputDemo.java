package com.orange.thread;

/**
 * @author:GLGGAG
 * @Date:2017/10/31
 * @Description:
 */
public class InputDemo extends  Thread {

    private SourceDemo  s;

    public InputDemo(SourceDemo  demo){
        this.s=demo;
    }


    @Override
    public void run() {
        int i=0;
        while (true){
            synchronized (s){
                if (s.flag){
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i%2==0){
                    s.name="zhangSan";
                    s.sex="man";
                }else{
                    s.name="lisi";
                    s.sex="woman";
                }
                s.flag=true;
                s.notify();
                i++;
            }
        }

    }
}
