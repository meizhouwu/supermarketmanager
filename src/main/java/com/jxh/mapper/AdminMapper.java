package com.jxh.mapper;

import com.jxh.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author meizh
 */
@Mapper
public interface AdminMapper {
    Admin findAdminByUsername(String username);
}
