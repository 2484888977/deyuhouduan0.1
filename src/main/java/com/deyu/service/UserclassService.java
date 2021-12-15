package com.deyu.service;

import com.deyu.pojo.Userclass;

import java.util.List;

public interface UserclassService {
    //获取部门类别
    List<Userclass> queryUserclass();
    //    学院/部门单位名称查询id
    Userclass queryUserclassinfoid(String userinfo);
}
