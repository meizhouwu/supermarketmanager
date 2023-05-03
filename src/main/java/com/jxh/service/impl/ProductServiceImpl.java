package com.jxh.service.impl;

import com.jxh.domain.Product;
import com.jxh.mapper.ProductMapper;
import com.jxh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList(String code,Long category_id,Long supplier_id) {
        return productMapper.getProductList(code,category_id,supplier_id);
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.findProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteProduct(id);
    }

    @Override
    public void deleteProductByCategory_id(Long id) {
        productMapper.deleteProductByCategory_id(id);
    }
}
