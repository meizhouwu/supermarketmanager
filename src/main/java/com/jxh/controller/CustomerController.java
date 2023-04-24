package com.jxh.controller;

import com.jxh.domain.Customer;
import com.jxh.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author meizh
 * 顾客控制层
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    /**
     * 查看所有顾客信息
     */
    @RequestMapping("/list")
    public String listCustomer(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("list",customerList);
        return "customerList";
    }

    /**
     * 查看单个
     */
    @RequestMapping("/view")
    public String view(Model model,Long id) {
        Customer customerById = customerService.findCustomerById(id);
        model.addAttribute("one",customerById);
        return "customerView";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String addCustomer(Customer customer) {
        customer.setCreate_time(new Date());
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/update")
    public String updateCustomer(Customer customer) {
        customer.setUpdate_time(new Date());
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "customerAdd";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model) {
        Customer customerById = customerService.findCustomerById(id);
        model.addAttribute("one",customerById);
        return "customerUpdate";
    }


}
