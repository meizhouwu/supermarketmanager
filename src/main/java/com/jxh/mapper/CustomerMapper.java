package com.jxh.mapper;

import com.jxh.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author meizh
 * 顾客接口方法
 */
@Mapper
public interface CustomerMapper {
    /**
     * 查询所有顾客信息
     */
    List<Customer> getCustomerList(@Param("name") String name);

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
