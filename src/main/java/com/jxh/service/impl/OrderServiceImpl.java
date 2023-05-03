package com.jxh.service.impl;

import com.jxh.domain.Order;
import com.jxh.mapper.OrderMapper;
import com.jxh.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrderList(String order_sn,Long customer_id,Integer state) {
        return orderMapper.getOrderList(order_sn,customer_id,state);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderMapper.deleteOrder(id);
    }
}
