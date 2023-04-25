package com.jxh.service;

import com.jxh.domain.SystemLog;

import java.util.List;

public interface ISystemLogService {
    List<SystemLog> getSystemLogList();

    SystemLog getSystemLog(Long id);

    void deleteSystemLog(Long id);
}
