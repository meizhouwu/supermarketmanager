package com.jxh.service.impl;

import com.jxh.domain.Admin;
import com.jxh.exception.BusinessException;
import com.jxh.mapper.AdminMapper;
import com.jxh.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author meizh
 */
@Service
public class AdminServiceImpl implements IAdminService {


    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin login(Admin admin) {
        //通过用户名查询数据库
        Admin dbadmin = adminMapper.findAdminByUsername(admin.getUsername());
        if (dbadmin == null) {
            //没查到，就报错
            //BusinessException写的自定义异常类
            throw new BusinessException("用户名错误");
        } else {
            //密码不匹配
            if (!dbadmin.getPassword().equals(admin.getPassword())) {
                throw new BusinessException("密码错误");
            } else {
                //都对了，返回查到的对象给前端
                return dbadmin;
            }
        }
    }

    /**
     * 修改密码
     */
    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }
}
