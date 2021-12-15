package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.TeacherMapper;
import com.deyu.pojo.Teacher;
import com.deyu.pojo.Teacher_view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    //添加教师信息
    public JSON addTeacherInfo(Teacher teacher) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = teacherMapper.addTeacherInfo(teacher);
            if (code == 1) {
                json.put("msg", "添加教师信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "添加教师信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //修改教师信息
    @Override
    public JSON updataTeacherInfo(Teacher teacher) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = teacherMapper.updateTeacherInfo(teacher);
            if (code == 1) {
                json.put("msg", "修改教师信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "修改教师信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //删除教师信息
    @Override
    public JSON deleteTeacherInfo(int teacherid) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = teacherMapper.deleteTeacherInfo(teacherid);
            if (code == 1) {
                json.put("msg", "删除教师信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "删除教师信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }
    //查看编辑

    @Override
    public List<Teacher_view> selectTeacher01(int teacherid) {
        return teacherMapper.selectTeacher01(teacherid);
    }

    //通过学院查找辅导员
    @Override
    public List<Teacher_view> selectCollegeTeacher(int collegeid) {
        return teacherMapper.selectCollegeTeacher(collegeid);
    }

    //    查询全部教师
    @Override
    public List<Teacher_view> selectTeacher() {
        return teacherMapper.selectTeacher();
    }

    //查找教师信息
    @Override
    public List<Teacher_view> seleteTeacherInfo(int page, int limit, String Keyword) {
        return teacherMapper.selectTeacherInfo(page, limit, Keyword);
    }

}
