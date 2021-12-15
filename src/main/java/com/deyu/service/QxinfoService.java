package com.deyu.service;

import com.deyu.pojo.Qxinfo;

import java.util.List;

public interface QxinfoService {
    //获取权限
    List<Qxinfo> queryQxinfo();
    //获取权限id
    Qxinfo queryQxinfoid(String jurisdictioninfo);
}
