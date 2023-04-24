package com.jxh.service.impl;

import com.jxh.domain.Customer;
import com.jxh.mapper.CustomerMapper;
import com.jxh.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meizh
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getCustomerList() {
        return customerMapper.getCustomerList();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerMapper.findCustomerById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerMapper.deleteCustomer(id);
    }
}
