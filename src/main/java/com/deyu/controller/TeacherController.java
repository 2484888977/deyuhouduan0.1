package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Teacher;
import com.deyu.pojo.Teacher_view;
import com.deyu.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("TercherController")
@Controller
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("addTeacher")
    @ResponseBody
    @CrossOrigin
    public JSON addTeacherInfo(Teacher teacher) {
        return teacherService.addTeacherInfo(teacher);
    }

    @GetMapping("updataTeacher")
    @ResponseBody
    @CrossOrigin
    public JSON updataTeacherInfo(Teacher teacher) {
        return teacherService.updataTeacherInfo(teacher);
    }

    @GetMapping("deleteTeacher")
    @ResponseBody
    @CrossOrigin
    public JSON deleteTeacherInfo(int teacherid) {
        return teacherService.deleteTeacherInfo(teacherid);
    }

    //查询全部教师
    @GetMapping("selectTercher01")
    @ResponseBody
    @CrossOrigin
    public List<Teacher_view> selectTeacher01() {
        return teacherService.selectTeacher();
    }

    //    通过学院查找辅导员
    @GetMapping("selectCollegeTeacher")
    @ResponseBody
    @CrossOrigin
    public List<Teacher_view> selectCollegeTeacher(int collegeid) {
        return teacherService.selectCollegeTeacher(collegeid);
    }

    //查询编辑教师
    @GetMapping("selectTercher02")
    @ResponseBody
    @CrossOrigin
    public List<Teacher_view> selectTeacher02(int teacherid) {
        return teacherService.selectTeacher01(teacherid);
    }

    //查询教师列表
    @GetMapping("selectTercher")
    @ResponseBody
    @CrossOrigin
    public JSON selectTeacherInfo(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", teacherService.seleteTeacherInfo(0, 100000, null).size());
        json.put("data", teacherService.seleteTeacherInfo(page2, limit, null));
        return json;
    }

    //    关键字查询教师
    @GetMapping("selectWhereTercher")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereTeacherInfo(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", teacherService.seleteTeacherInfo(0, 100000, Keyword).size());
        json.put("data", teacherService.seleteTeacherInfo(page2, limit, Keyword));
        return json;
    }
}
