package com.orange.framework.aop;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 */
public class TestBean {

    private String str="testStr";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void test(){
        System.out.println("test");
    }

}
