package com.jxh.service.impl;

import com.jxh.domain.Supplier;
import com.jxh.mapper.SupplierMapper;
import com.jxh.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meizh
 */
@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getSupplierList(String name) {
        return supplierMapper.getSupplierList(name);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierMapper.getSupplierById(id);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierMapper.deleteSupplier(id);
    }
}
