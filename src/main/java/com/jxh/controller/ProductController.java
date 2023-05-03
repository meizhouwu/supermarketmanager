package com.jxh.controller;


import com.jxh.domain.Category;
import com.jxh.domain.Product;
import com.jxh.domain.Supplier;
import com.jxh.service.ICategoryService;
import com.jxh.service.IProductService;
import com.jxh.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISupplierService supplierService;

    /**
     * 查看所有
     */
    @RequestMapping("/list")
    public String listProduct(Model model,String name,String code,Long category_id,Long supplier_id) {
        List<Product> productList = productService.getProductList(code,category_id,supplier_id);
        model.addAttribute("list",productList);
        List<Category> categoryList = categoryService.getCategoryList(name);
        model.addAttribute("cList",categoryList);
        List<Supplier> supplierList = supplierService.getSupplierList(name);
        model.addAttribute("sList",supplierList);
        return "productList";
    }

    /**
     * 查看单个
     */
    @RequestMapping("/view")
    public String view(Model model,Long id) {
        Product productById = productService.findProductById(id);
        model.addAttribute("one",productById);
        return "productView";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/product/list";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/product/list";
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteProduct(Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model,String name) {
        List<Category> categoryList = categoryService.getCategoryList(name);
        model.addAttribute("cList",categoryList);
        List<Supplier> supplierList = supplierService.getSupplierList(name);
        model.addAttribute("sList",supplierList);
        return "productAdd";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model,String name) {
        Product productById = productService.findProductById(id);
        model.addAttribute("one",productById);
        List<Category> categoryList = categoryService.getCategoryList(name);
        model.addAttribute("cList",categoryList);
        List<Supplier> supplierList = supplierService.getSupplierList(name);
        model.addAttribute("sList",supplierList);
        return "productUpdate";
    }

}
