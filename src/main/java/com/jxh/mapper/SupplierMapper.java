package com.jxh.mapper;

import com.jxh.domain.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author meizh
 */
@Mapper
public interface SupplierMapper {
    /**
     * 查询所有供应商信息
     */
    List<Supplier> getSupplierList(@Param("name") String name);

    /**
     * 查询顾客信息通过id
     */
    Supplier getSupplierById(Long id);


    /**
     * 添加供应商信息
     */
    void addSupplier(Supplier supplier);

    /**
     * 修改供应商信息
     */
    void updateSupplier(Supplier supplier);

    /**
     * 删除供应商
     */
    void deleteSupplier(Long id);
}
