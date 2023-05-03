package com.jxh.mapper;

import com.jxh.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProductList(@Param("code") String code, @Param("category_id") Long category_id, @Param("supplier_id") Long supplier_id);

    Product findProductById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);

    void deleteProductByCategory_id(Long id);
}
