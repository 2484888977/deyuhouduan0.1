package com.deyu.mapper;

import com.deyu.pojo.Userclass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserclassMapper {
    //专业信息管理
    List<Userclass> queryUserclass();

    //    学院/部门单位名称查询id
    Userclass queryUserclassinfoid(String userinfo);
}
