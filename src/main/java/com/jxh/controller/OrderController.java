package com.jxh.controller;

import com.jxh.domain.Customer;
import com.jxh.domain.Order;
import com.jxh.service.ICustomerService;
import com.jxh.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author meizh
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICustomerService customerService;


    /**
     * 查看所有订单信息
     */
    @RequestMapping("/list")
    public String listOrder(Model model) {
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("list",orderList);
        return "orderList";
    }

    /**
     * 查看单个
     */
    @RequestMapping("/view")
    public String view(Model model,Long id) {
        Order orderById = orderService.getOrderById(id);
        model.addAttribute("one",orderById);
        return "orderView";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String addOrder(Order order,Model model) {
        orderService.addOrder(order);
        return "redirect:/order/list";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public String updateOrder(Order order) {
        orderService.updateOrder(order);
        return "redirect:/order/list";
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteOrder(Long id) {
        orderService.deleteOrder(id);
        return "redirect:/order/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("list",customerList);
        return "orderAdd";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Long id,Model model) {
        Order orderById = orderService.getOrderById(id);
        model.addAttribute("one",orderById);
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("list",customerList);
        return "orderUpdate";
    }
}
