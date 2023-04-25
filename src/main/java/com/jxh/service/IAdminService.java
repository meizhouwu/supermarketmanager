package com.jxh.service;

import com.jxh.domain.Admin;

public interface IAdminService {
    Admin login(Admin admin);

    void updateAdmin(Admin admin);
}
