package com.jxh.mapper;

import com.jxh.domain.SystemLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemLogMapper {
    List<SystemLog> getSystemLogList();

    SystemLog getSystemLog(Long id);

    void deleteSystemLog(Long id);

    void addSystemLog(SystemLog log);

    void updateSystemLog(SystemLog systemLog);
}
