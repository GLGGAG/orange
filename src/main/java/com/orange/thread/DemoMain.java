package com.orange.thread;

/**
 * @author:GLGGAG
 * @Date:2017/10/31
 * @Description:
 */
public class DemoMain {

    public static void main(String[] args) {
        SourceDemo s = new SourceDemo();
        InputDemo in = new InputDemo(s);
        OutputDemo ou = new OutputDemo(s);
        in.start();
        ou.start();
    }
}
