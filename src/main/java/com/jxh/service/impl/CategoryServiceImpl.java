package com.jxh.service.impl;

import com.jxh.domain.Category;
import com.jxh.mapper.CategoryMapper;
import com.jxh.mapper.ProductMapper;
import com.jxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Category> getCategoryList(String name) {
        return categoryMapper.getCategoryList(name);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryMapper.findCategoryById(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        productMapper.deleteProductByCategory_id(id);
        categoryMapper.deleteCategory(id);
    }


}
