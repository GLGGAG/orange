package com.orange.vos;

import java.util.List;

/**
 * @author: GLGGAG
 * @Date: 2017/08/22/上午 10:51
 * @Description:
 */
public class CategoryVo {

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
     * 子类目vo
     */
    private List<CategoryVo> subCategoryVo;

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

    public List<CategoryVo> getSubCategoryVo() {
        return subCategoryVo;
    }

    public void setSubCategoryVo(List<CategoryVo> subCategoryVo) {
        this.subCategoryVo = subCategoryVo;
    }
}
