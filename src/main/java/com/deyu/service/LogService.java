package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Syslog;

public interface LogService {
    //新增日志
    int addLog(Syslog syslog);
    //查看日志
    JSON selectLogInfo(int page, int limit);
}
