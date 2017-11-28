package com.orange.framework.aop.cglibproxy;




import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 */
public class MethodInterceptorImpl implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke====="+method);
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after  invoke===="+method);
        return result;
    }
}
