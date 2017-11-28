package com.orange.service.impl;

import com.orange.entity.Category;
import com.orange.mapper.CategoryMapper;
import com.orange.service.ICategoryService;
import com.orange.support.date.DateFormatType;
import com.orange.support.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author:GLGGAG
 * @Date:2017/10/23
 * @Description:
 */
@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = IllegalArgumentException.class)
    public void updateCategoryTransactionTest() {
        int i = categoryMapper.updateByCategryName(111);
        System.out.println("======================1");
        if (i==1){
            //throw  new IllegalArgumentException();
        }
    }

    @Override
    public void insertMillionData() {
        int i=0;
        for (;i<10000000;i++){
            Category category = new Category();
            category.setCategoryName("当前"+i);
            category.setPriority(i);
            category.setCategoryNo(i);
            category.setCategoryParentNo(i);
            categoryMapper.insert(category);
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(1510003031296L), DateFormatType.YYYY_MM_DD_HH_MM_SS));
    }

}
