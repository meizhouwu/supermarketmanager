package com.jxh.service;

import com.jxh.domain.Order;

import java.util.List;

public interface IOrderService {
    /**
     * 查询所有订单信息
     */
    List<Order> getOrderList(String order_sn,Long customer_id,Integer state);

    /**
     * 查询订单信息通过id
     */
    Order getOrderById(Long id);


    /**
     * 添加订单信息
     */
    void addOrder(Order order);

    /**
     * 修改订单信息
     */
    void updateOrder(Order order);

    /**
     * 删除订单
     */
    void deleteOrder(Long id);
}
