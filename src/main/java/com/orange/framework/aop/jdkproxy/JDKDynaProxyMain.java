package com.orange.framework.aop.jdkproxy;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 */
public class JDKDynaProxyMain {


    public static void main(String[] args) {
        IUserService user = new UserServiceImpl();
        MyInvocationHandler inHandler = new MyInvocationHandler(user);
        IUserService proxyUser=(IUserService)inHandler.getProxy();
        proxyUser.add();
    }
}
