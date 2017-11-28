package com.orange.vos;

public class ArticleReadVo {

    //当前文章所属于类目的所有信息信息
    private CategoryVo categoryVo;

    //当前需要暂时文章
    private ArticleVo articleVo;

    public CategoryVo getCategoryVo() {
        return categoryVo;
    }

    public void setCategoryVo(CategoryVo categoryVo) {
        this.categoryVo = categoryVo;
    }

    public ArticleVo getArticleVo() {
        return articleVo;
    }

    public void setArticleVo(ArticleVo articleVo) {
        this.articleVo = articleVo;
    }
}
