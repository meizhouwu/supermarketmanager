package com.jxh.service;

import com.jxh.domain.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * 查询所有商品分类信息
     */
    List<Category> getCategoryList(String name);

    /**
     * 查询商品分类信息通过id
     */
    Category findCategoryById(Long id);


    /**
     * 添加商品分类信息
     */
    void addCategory(Category category);

    /**
     * 修改商品分类信息
     */
    void updateCategory(Category category);

    /**
     * 删除商品分类
     */
    void deleteCategory(Long id);


}
