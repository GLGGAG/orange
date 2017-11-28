package com.orange.vos;

import java.util.Date;
import java.util.List;

public class ArticleVo {

    //当前文章所属类目
    private Integer categoryNo;

    //文章articleNo
    private Integer articleNo;

    //当前文章标题
    private  String title;

    //文章内容
    private String context;

    //文章创建时间
    private Date creatTime;

    //文章更新时间
    private Date updateTime;

    //文章标签
    private List<String> tags;

    //文章标题图片地址
    private String titleImage;

    //是否删除
    private  Boolean deleted;

    //点赞次数
    private  Integer  starNumber;

    //文章阅读数
    private Integer readNumber;

    //暂时留着，可能使用mogondb会更好
    private List<ArticleCommentVo> commentVos;

    public Integer getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(Integer categoryNo) {
        this.categoryNo = categoryNo;
    }

    public Integer getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(Integer articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(Integer starNumber) {
        this.starNumber = starNumber;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public List<ArticleCommentVo> getCommentVos() {
        return commentVos;
    }

    public void setCommentVos(List<ArticleCommentVo> commentVos) {
        this.commentVos = commentVos;
    }
}
