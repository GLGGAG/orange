package com.orange.mapper;


import com.orange.entity.Category;
import com.orange.vos.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: GLGGAG
 * @Date: 2017/08/22/上午 10:30
 * @Description:
 */
public interface CategoryMapper {

    /**
     * @param categoryNo  类目编号
     * @return 承载数据的类目vo
     */
    List<CategoryVo>  totalSubCategory(@Param("categoryNo") Integer categoryNo);


    Category    findByCategoryNo(@Param("categoryNo") Integer categoryNo);

    int updateByCategryName(@Param("categoryNo") Integer categoryNo);

    void insert(@Param("ca") Category category);
}
