package com.deyu.service;


import com.deyu.mapper.UserclassMapper;
import com.deyu.pojo.Userclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserclassServiceImpl implements UserclassService{

    @Autowired
    private UserclassMapper userclassMapper;

    //获取部门类别
    @Override
    public List<Userclass> queryUserclass() {
        return userclassMapper.queryUserclass();
    }

    @Override
    public Userclass queryUserclassinfoid(String userinfo) {
        return userclassMapper.queryUserclassinfoid(userinfo);
    }
}
