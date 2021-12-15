package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Major;
import com.deyu.pojo.Major_view;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MajorService {
    //添加专业
    JSON addMajorInfo(Major major);

    //修改专业
    JSON updateMajorInfo(Major major);

    //删除专业
    JSON deleteMajorInfo(int majorid);

    //查看编辑
    List<Major_view> queryMajor(int majorid);

    //查看全部专业
    List<Major_view> selectMajor();
    //通过学院查找专业
    List<Major_view> selectCollegeMajor(int collegeid);

    //查看专业
    List<Major_view> selectMajorInfo(int page, int limit,String Keyword);
}
