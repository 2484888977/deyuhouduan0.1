package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.College;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeService {
    JSON addCollegeinfo(College college);

    JSON deleteCollegeInfo(int collegeid);

    //    查询部门/学院
    List<College> queryCollegeAll();

    //修改学院/部门
    JSON updateCollegeInfo(College college);

    //id查询学院/部门
    List selectCollegeX(int collegeid);

    //查询部门
    List selectCollegeInfo(int page, int limit, String Keyword);

    //查询学院
    List selectCollegeInfo01(int page, int limit, String Keyword);

    //    查看学院
    List selectCollege();

    //    学院名转id
    List<College> selectCollegeXY(int collegeid);

    //    部门名转id
    List<College> selectCollegeXY01(int collegeid);

    //    查看部门
    List selectCollege01();

}
