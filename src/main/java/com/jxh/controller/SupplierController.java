package com.jxh.controller;

import com.jxh.domain.Supplier;
import com.jxh.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author meizh
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    /**
     * 查看所有顾客信息
     */
    @RequestMapping("/list")
    public String listSupplier(Model model,String name) {
        List<Supplier> supplierList = supplierService.getSupplierList(name);
        model.addAttribute("list",supplierList);
        return "supplierList";
    }

    /**
     * 查看单个
     */
    @RequestMapping("/view")
    public String view(Model model,Long id) {
        Supplier supplierById = supplierService.getSupplierById(id);
        model.addAttribute("one",supplierById);
        return "supplierView";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String addSupplier(Supplier supplier) {
        supplier.setCreate_time(new Date());
        supplierService.addSupplier(supplier);
        return "redirect:/supplier/list";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);
        return "redirect:/supplier/list";
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteSupplier(Long id) {
        supplierService.deleteSupplier(id);
        return "redirect:/supplier/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "supplierAdd";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model) {
        Supplier supplierById = supplierService.getSupplierById(id);
        model.addAttribute("one",supplierById);
        return "supplierUpdate";
    }
}
