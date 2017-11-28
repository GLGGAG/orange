
drop table if exists blog_category;

drop table if exists blog_articleStar;

drop table if exists blog_articleRead;

drop table if exists blog_article;

drop table if exists blog_visitor ;

drop table if exists blog_admin ;

drop table if exists blog_adminLog ;

drop table if exists blog_keyword ;

/*==============================================================*/
/* Table:博客文章分别类目表                                           */
/*==============================================================*/
create table blog_category
(
  id                   int not null AUTO_INCREMENT comment '主键',
  categoryName         varchar(20) NOT NULL comment '类目名称',
  categoryNo           INT  NOT NULL comment '类目编号',
  priority             INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '类目优先级',
  categoryParentNo     INT  NOT NULL DEFAULT 0 comment '类目父级编号',
  createTime           DATETIME  NOT NULL DEFAULT current_timestamp comment '创建时间',
  updateTime           DATETIME  NOT NULL DEFAULT  current_timestamp comment '修改时间',
  version              int UNSIGNED DEFAULT 0 comment '版本号',
  deleted              TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id),
  KEY (categoryNo)
);
/*==============================================================*/
/* Table:博客文章内容表                                           */
/*==============================================================*/
create table blog_article
(
  id                   int not null AUTO_INCREMENT comment '主键',
  articleNo            INT  NOT NULL COMMENT '文章编号',
  title                varchar(100)NOT NULL comment '文章标题',
  categoryNo           INT NOT NULL comment '文章所属类目编号',
  tags                 VARCHAR(10) COMMENT '文章标签名称(来自文章父级类目名称)',
  titleImage           VARCHAR(100) COMMENT '标题图片',
  content              TEXT COMMENT '文章内容',
  createTime           DATETIME  NOT NULL DEFAULT current_timestamp  comment '创建时间',
  updateTime           DATETIME  NOT NULL DEFAULT current_timestamp comment '修改时间',
  version              int  UNSIGNED DEFAULT 0 comment '版本号',
  deleted              TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id),
  KEY (articleNo)
);
/*==============================================================*/
/* Table:文章star表                                           */
/*==============================================================*/
create table blog_articleStar
(
  id                   int not null AUTO_INCREMENT comment '主键',
  articleNo            INT NOT NULL COMMENT '文章编号',
  starNumber           int UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞次数',
  createTime           DATETIME  NOT NULL  DEFAULT current_timestamp comment '创建时间',
  updateTime           DATETIME  NOT NULL DEFAULT current_timestamp comment '修改时间',
  version              int UNSIGNED DEFAULT 0 comment '版本号',
  deleted              TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id),
  KEY (articleNo)
);
/*==============================================================*/
/* Table:文章阅读次数表                                           */
/*==============================================================*/
create table blog_articleRead
(
  id                   int not null AUTO_INCREMENT comment '主键',
  articleNo            INT NOT NULL COMMENT '文章编号',
  readNmber            int UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章阅读次数',
  createTime           DATETIME  NOT NULL DEFAULT current_timestamp  comment '创建时间',
  updateTime           DATETIME  NOT NULL DEFAULT current_timestamp  comment '修改时间',
  version              int UNSIGNED DEFAULT 0 comment '版本号',
  deleted              TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id),
  key (articleNo)
);
/*==============================================================*/
/* Table:访客记录表                                           */
/*==============================================================*/
create table blog_visitor
(
  id                    int not null AUTO_INCREMENT comment '主键',
  ip                    VARCHAR(20)  COMMENT '访客ip',
  device                VARCHAR(20) comment '访客设备',
  behavior              VARCHAR(20) comment '访客浏览行为（点击主页或者点击其他页面）',
  articleNo             INT  COMMENT '访客点击文章编号(如果访客点击文章，则记录文章编号)',
  createTime            DATETIME  NOT NULL DEFAULT current_timestamp  comment '创建时间',
  updateTime            DATETIME  NOT NULL DEFAULT current_timestamp  comment '修改时间',
  version               int UNSIGNED DEFAULT 0 comment '版本号',
  deleted               TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id)
);
/*==============================================================*/
/* Table:管理员登陆日记记录表                                          */
/*==============================================================*/
create table blog_adminLog
(
  id                     int not null AUTO_INCREMENT comment '主键',
  ip                     VARCHAR(20)  COMMENT '管理员登陆ip',
  device                 VARCHAR(20) comment '管理员设备',
  createTime             DATETIME  NOT NULL DEFAULT current_timestamp comment '创建时间',
  updateTime             DATETIME  NOT NULL DEFAULT current_timestamp  comment '修改时间',
  version                int UNSIGNED DEFAULT 0 comment '版本号',
  deleted                TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id)
);
/*==============================================================*/
/* Table:管理员表                                          */
/*==============================================================*/
create table blog_admin
(
  id                     int not null AUTO_INCREMENT comment '主键',
  name                   VARCHAR(20) NOT NULL  COMMENT '管理员姓名',
  nickName               VARCHAR(20) comment '管理员别名',
  mobile                 CHAR(13)NOT NULL COMMENT '手机号码',
  passWord               VARCHAR(40)NOT NULL COMMENT '密码',
  loginNum               INT UNSIGNED  NOT NULL DEFAULT 0 COMMENT '登陆次数',
  avator                 VARCHAR(50) COMMENT  '头像地址',
  introduction           VARCHAR(100) COMMENT '自我介绍',
  motto                  VARCHAR(30) COMMENT '座右铭',
  createTime             DATETIME  NOT NULL DEFAULT current_timestamp comment '创建时间',
  updateTime             DATETIME  NOT NULL  DEFAULT current_timestamp comment '修改时间',
  version                int UNSIGNED DEFAULT 0 comment '版本号',
  deleted                TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id)
);

/*==============================================================*/
/* Table:文章关键字表                                          */
/*==============================================================*/
create table blog_keyword
(
  id                    int not null AUTO_INCREMENT comment '主键',
  keyword               VARCHAR(20)  COMMENT '关键字',
  articleNo             INT NOT NULL COMMENT '文章编号',
  createTime            DATETIME  NOT NULL DEFAULT current_timestamp comment '创建时间',
  updateTime            DATETIME  NOT NULL DEFAULT current_timestamp comment '修改时间',
  version               int UNSIGNED DEFAULT 0 comment '版本号',
  deleted               TINYINT DEFAULT FALSE comment '是否删除',
  primary key (id),
  KEY (articleNo)
);










