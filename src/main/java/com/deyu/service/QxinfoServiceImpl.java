package com.deyu.service;

import com.deyu.mapper.QxinfoMapper;
import com.deyu.pojo.Qxinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QxinfoServiceImpl implements QxinfoService{
    @Autowired
    private QxinfoMapper qxinfoMapper;

    @Override
    public List<Qxinfo> queryQxinfo() {
        return qxinfoMapper.queryQxinfo();
    }

    @Override
    public Qxinfo queryQxinfoid(String jurisdictioninfo) {
        return qxinfoMapper.queryQxinfoid(jurisdictioninfo);
    }
}
