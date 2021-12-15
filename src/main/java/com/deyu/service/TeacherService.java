package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Teacher;
import com.deyu.pojo.Teacher_view;

import java.util.List;

public interface TeacherService {
    //添加教师信息
    JSON addTeacherInfo(Teacher teacher);

    //修改教师信息
    JSON updataTeacherInfo(Teacher teacher);

    //删除教师信息
    JSON deleteTeacherInfo(int teacherid);
    //查看编辑
    List<Teacher_view> selectTeacher01(int teacherid);
    //通过学院查找辅导员
    List<Teacher_view> selectCollegeTeacher(int collegeid);

    //查询全部教师
    List<Teacher_view> selectTeacher();

    //查找教师信息
    List<Teacher_view> seleteTeacherInfo(int page, int limit, String Keyword);
}
