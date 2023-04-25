package com.jxh.service.impl;

import com.jxh.domain.SystemLog;
import com.jxh.mapper.SystemLogMapper;
import com.jxh.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements ISystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public List<SystemLog> getSystemLogList() {
        return systemLogMapper.getSystemLogList();
    }

    @Override
    public SystemLog getSystemLog(Long id) {
        return systemLogMapper.getSystemLog(id);
    }

    @Override
    public void deleteSystemLog(Long id) {
        systemLogMapper.deleteSystemLog(id);
    }
}
