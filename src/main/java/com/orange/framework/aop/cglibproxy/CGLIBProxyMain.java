package com.orange.framework.aop.cglibproxy;

import org.mockito.cglib.proxy.Callback;
import org.mockito.cglib.proxy.Enhancer;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 */
public class CGLIBProxyMain {

    public static void main(String[] args) {

        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new  MethodInterceptorImpl());
        EnhancerDemo demo=(EnhancerDemo)enhancer.create();
        demo.test();
        System.out.println(demo);
    }

}
