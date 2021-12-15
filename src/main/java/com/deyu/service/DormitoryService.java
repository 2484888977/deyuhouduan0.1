package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Dormitory;
import com.deyu.pojo.Dormitory_view;

import java.util.List;

public interface DormitoryService {
    //添加学生寝室
    JSON addDormitory(Dormitory dormitory);
    //删除寝室号
    JSON deleteDormitory(int dormitoryid);
    //修改寝室号
    JSON updateDormitory(Dormitory dormitory);
    //查看/关键字查询寝室
    List selectDormitoryinfo(int page,int limit,String Keyword);
    //查看/编辑
    List<Dormitory_view> queryDormitoryinfo(int dormitoryid);
    List<Dormitory_view> queryDormitoryinfoid(String apartmentinfo);
    List<Dormitory_view> queryDormitoryin(String dormitoryinfo);
}
