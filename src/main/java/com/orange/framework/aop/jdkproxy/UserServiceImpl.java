package com.orange.framework.aop.jdkproxy;

/**
 * @author : GLGGAG
 * @since : 2017/11/16
 */
public class UserServiceImpl  implements IUserService{

    /**
     * @see com.orange.framework.aop.jdkproxy.IUserService#add()
     */
    @Override
    public void add() {
        System.out.println("-------------------------------add-----------------------------------------------");
    }
}
