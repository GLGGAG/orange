package com.orange.controller;

import com.google.common.base.Preconditions;
import com.orange.controller.base.BaseController;
import com.orange.service.ICategoryService;
import com.orange.support.message.ResponseMessage;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:GLGGAG
 * @Date:2017/10/19
 * @Description:主页控制器
 */
@RestController
@RequestMapping("main")
public class MainController extends BaseController{

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("hello")
    public ResponseMessage<Object> sayHello(int param){
        Preconditions.checkArgument(param>=0,"期望参数 param >= 0,得到",param);
        iCategoryService.updateCategoryTransactionTest();
        return new ResponseMessage<Object>();
    }

    @RequestMapping("insert")
    public ResponseMessage<Object> insertMillion(){
        iCategoryService.insertMillionData();
        MDC.put("endTime",String.valueOf(System.currentTimeMillis()));
        return new ResponseMessage<Object>();
    }



}
