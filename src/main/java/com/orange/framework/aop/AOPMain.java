package com.orange.framework.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 * AOP切面编程mainDemo方法类
 * 演示aop demo
 */
public class AOPMain {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("aop/apsectTest.xml");
        TestBean bean=(TestBean)cc.getBean("TestBean");
        bean.test();
    }
}
