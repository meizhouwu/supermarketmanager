package com.jxh.mapper;


import com.jxh.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author meizh
 * 订单接口方法
 */
@Mapper
public interface OrderMapper {
    /**
     * 查询所有订单信息
     */
    List<Order> getOrderList(@Param("order_sn") String order_sn, @Param("customer_id") Long customer_id, @Param("state") Integer state);

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
