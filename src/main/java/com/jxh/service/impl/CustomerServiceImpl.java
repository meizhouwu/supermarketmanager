package com.jxh.service.impl;

import com.jxh.domain.Customer;
import com.jxh.mapper.CustomerMapper;
import com.jxh.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author meizh
 */
@Service
@Transactional(readOnly = false,propagation = Propagation.SUPPORTS)
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

    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }


    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Long id) {
        customerMapper.deleteCustomer(id);
    }

}
