package com.orange.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author : GLGGAG
 * @since : 2017/11/168
 */
@Aspect
public class AspectTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){}

    @Before("test()")
    public void beforeTest() throws Exception {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o=null;
        try {
            o=p.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }





}
