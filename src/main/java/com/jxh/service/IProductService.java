package com.jxh.service;

import com.jxh.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList(String code,Long category_id,Long supplier_id);

    Product findProductById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);

    void deleteProductByCategory_id(Long id);
}
