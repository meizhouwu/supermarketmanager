package com.jxh.controller;

import com.jxh.domain.Category;
import com.jxh.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author meizh
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    /**
     * 查看所有
     */
    @RequestMapping("/list")
    public String listCategory(Model model,String name) {
        List<Category> categoryList = categoryService.getCategoryList(name);
        model.addAttribute("list",categoryList);
        return "categoryList";
    }

    /**
     * 查看单个
     */
    @RequestMapping("/view")
    public String view(Model model,Long id) {
        Category categoryById = categoryService.findCategoryById(id);
        model.addAttribute("one",categoryById);
        return "categoryView";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:/category/list";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category/list";
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "categoryAdd";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model) {
        Category categoryById = categoryService.findCategoryById(id);
        model.addAttribute("one",categoryById);
        return "categoryUpdate";
    }


//    @RequestMapping("/query")
//    public String query(CategoryQuery categoryQuery, Model model){
//        List<Category> categoryList = categoryService.getCategoryList();
//        model.addAttribute("categoryQuery",categoryQuery);
//        model.addAttribute("list",categoryList);
//        return "categoryList";
//    }
}
