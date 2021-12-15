package com.deyu.service;

import com.deyu.pojo.Systemlog;
import com.deyu.pojo.Zlog_view;

import java.util.List;

public interface SystemlogService {
    //查询系统操作日志/关键字查询
    List querySystemlog(int page, int limit, String Keyword);
    //    学分操作日志查询-->
    List<Zlog_view> selectZlogview(int page, int limit, String Keyword);
    List<Zlog_view> selectZlogviewinfo(int id);
}
