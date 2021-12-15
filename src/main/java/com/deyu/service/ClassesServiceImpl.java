package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.ClassesMapper;
import com.deyu.mapper.CollegeMapper;
import com.deyu.mapper.MajorMapper;
import com.deyu.mapper.TeacherMapper;
import com.deyu.pojo.Class_View;
import com.deyu.pojo.Classes;
import com.deyu.util.ExcelUtil.ExcelUtil;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private CollegeMapper collegeMapper;


    @Override
    public JSON addClasses(Classes classes) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = classesMapper.addClasses(classes);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "添加班级信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "添加班级信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }
    //批量添加班级信息
    @Override
    public JSON addAllClasses(String filepath){
        ExcelUtil readexcel = new ExcelUtil();
        filepath = "E:\\我的文件\\测试\\测试.xlsx";
        Map<Integer, Map<Integer, Object>> map = readexcel.ReadExcelcontent(filepath);
        System.out.println(map);
        //学生集合
        List<Classes> classesList = new ArrayList<Classes>();
        for (int i = 1; i <= map.size(); i++) {
            Classes classes = new Classes();
            classes.setClasses((int)map.get(i).get(0));
            classes.setTeacherid(teacherMapper.queryTeacherinfoid(String.valueOf(map.get(i).get(1))).get(0).getTeacherid());
            classes.setMajorid(majorMapper.queryMajorinfoid(String.valueOf(map.get(i).get(2))).get(0).getMajorid());
            classes.setCollegeid(collegeMapper.queryCollegeinfoid(String.valueOf(map.get(i).get(3))).get(0).getCollegeid());
            classesList.add(classes);
        }
        System.out.println(classesList);
        JSONObject json = new JSONObject();
        int code = 0;
        code = classesMapper.addAllClasses(classesList);
        if (code == 0) {
            json.put("msg", "批量添加失败");
            json.put("code", 1);
        } else {
            json.put("msg", "批量添加成功");
            json.put("code", 0);
        }
        return json;
    }

    //删除班级
    @Override
    public JSON deleteClasses(int classes) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = classesMapper.deleteClasses(classes);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "删除班级信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "删除班级信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }

    //    修改班级
    @Override
    public JSON updataClasses(Classes classes) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = classesMapper.updataClasses(classes);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "修改班级信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "修改班级信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }

    //通过学院查找班级
    @Override
    public List<Class_View> selectCollegeClass(int collegeid) {
        return classesMapper.selectCollegeClass(collegeid);
    }

    //    查询班级/关键字查询
    @Override
    public List<Class_View> selectClasses(int page, int limit, String Keyword) {
        return classesMapper.selectClasses(page, limit, Keyword);
    }

    //查看/编辑
    @Override
    public List<Class_View> queryClassinfo(int classes) {
        return classesMapper.queryClassinfo(classes);
    }

    //查询全部班级-->
    @Override
    public List<Class_View> selectwhereClasses() {
        return classesMapper.selectwhereClasses();
    }
}
