package com.dahuzi.stream2demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 商品运营分类
 * Created by Mybatis Generator on 2018/09/06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OprCategoryEntity
{
    //id主键
    private Long id;

    //店铺ID
    private Long shopId;

    //分类名称
    private String categoryName;

    //分类编号,编码唯一
    private String categoryNo;

    //分类图片
    private String categoryPic;

    //父分类ID
    private Long parentId;

    //是否叶子节点，0父节点，1叶子节点
    private Integer leaf = 0;

    //分类等级，1,2,3
    private Integer level;

    //栏目ID
    private Long subjectId;

    //备注
    private String remark;

    //删除栏目ID，1：不显示在栏目上，0：正常显示
    private Integer delSubjectId;

    //
    private String createUser;

    //
    private Date createTime;

    //
    private String updateUser;

    //
    private Date updateTime;

    //状态 0展示、1隐藏
    private Integer status;
    //排序
    private Integer sort;
}