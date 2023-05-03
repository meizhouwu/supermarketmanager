package com.jxh.service;

import com.jxh.domain.Customer;

import java.util.List;

/**
 *
 * @author meizh
 */
public interface ICustomerService {
    /**
     * 查询所有顾客信息
     */
    List<Customer> getCustomerList(String name);

    /**
     * 查询顾客信息通过id
     */
    Customer findCustomerById(Long id);


    /**
     * 添加顾客信息
     */
    void addCustomer(Customer customer);

    /**
     * 修改顾客信息
     */
    void updateCustomer(Customer customer);

    /**
     * 删除顾客
     */
    void deleteCustomer(Long id);
}
