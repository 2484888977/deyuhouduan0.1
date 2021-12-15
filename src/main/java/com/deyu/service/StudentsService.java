package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Quanxian;
import com.deyu.pojo.Stu_view;
import com.deyu.pojo.Students;
import com.deyu.pojo.User;


import java.util.List;

public interface StudentsService {

    //添加学生
    JSON addStudentsInfo(Students students);
    //添加学生
    JSON addAllStudent(Students students);
    //修改学生
    JSON updateStudentsInfo(Students students);
    //学生学分更改
    JSONObject editStudentScore(int id);
    //查看——学生学分
    JSONObject queryStudentScore(String s_id, String s_proid);

    //查看学生详情
    Stu_view selectStudentDetails(String s_id);

    //删除学生
    JSON deleteStudentsInfo(String s_id);

    //查找学生
//    List<Stu_view> selectStudentsInfo(int page, int limit,String Keyword);
    List<Stu_view> selectStudentsInfo(int page, int limit, String Keyword, User user);

    //权限控制数据
    Quanxian quanxianif(User user);

}
