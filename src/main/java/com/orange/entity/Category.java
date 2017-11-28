package com.orange.entity;


import com.orange.entity.base.BaseEntity;

/**
 * @author: GLGGAG
 * @Date: 2017/08/22/上午 10:21
 * @Description:
 */
public class Category extends BaseEntity {
    /**
     * 当前文章类目名称
     */
    private String categoryName;

    /**
     * 文章类目编号
     */
    private  Integer categoryNo;

    /**
     * 文章类目父级编号
     */
    private  Integer categoryParentNo;

    /**
     * 类目优先级
     */
    private Integer priority;


    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(Integer categoryNo) {
        this.categoryNo = categoryNo;
    }

    public Integer getCategoryParentNo() {
        return categoryParentNo;
    }

    public void setCategoryParentNo(Integer categoryParentNo) {
        this.categoryParentNo = categoryParentNo;
    }
}
