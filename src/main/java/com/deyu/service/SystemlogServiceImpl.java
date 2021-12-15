package com.deyu.service;

import com.deyu.mapper.SystemlogMapper;
import com.deyu.pojo.Systemlog;
import com.deyu.pojo.Zlog_view;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemlogServiceImpl implements SystemlogService{

    @Autowired
    private SystemlogMapper systemlogMapper;

    @Override
    public List querySystemlog(int page, int limit, String Keyword) {
        return systemlogMapper.querySystemlog(page, limit,Keyword);
    }
// <!--    //    学分操作日志查询-->

    @Override
    public List<Zlog_view> selectZlogview(int page, int limit, String Keyword) {
        return systemlogMapper.selectZlogview(page,limit,Keyword);
    }

    @Override
    public List<Zlog_view> selectZlogviewinfo(int id) {
        return systemlogMapper.selectZlogviewinfo(id);
    }
}
