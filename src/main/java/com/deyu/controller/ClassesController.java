package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.*;
import com.deyu.pojo.Class_View;
import com.deyu.pojo.Classes;
import com.deyu.pojo.Students;
import com.deyu.service.ClassesServiceImpl;
import com.deyu.service.StudentsServiceImpl;
import com.deyu.util.ParseExcel;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/ClassesController")
public class ClassesController {
    @Autowired
    private ClassesServiceImpl classesService;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private ApartmentMapper apartmentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentsServiceImpl studentsService;

    @GetMapping("/addClasses")
    @ResponseBody
    @CrossOrigin
    public JSON addClasses(Classes classes) {
        return classesService.addClasses(classes);
    }

    //删除班级
    @GetMapping("/deleteClasses")
    @ResponseBody
    @CrossOrigin
    public JSON deleteClasses(int classes) {
        return classesService.deleteClasses(classes);
    }

    //修改班级
    @GetMapping("/updataClasses")
    @ResponseBody
    @CrossOrigin
    public JSON updataClasses(Classes classes) {
        return classesService.updataClasses(classes);
    }

    //班级信息管理全部查找
    @GetMapping("/queryClasses")
    @ResponseBody
    @CrossOrigin
    public List queryClasses1() {
        return classesService.selectwhereClasses();
    }


    //查看/编辑
    @GetMapping("/queryClassinfo")
    @ResponseBody
    @CrossOrigin
    public List queryClassinfo(int classesid) {
        return classesService.queryClassinfo(classesid);
    }


    //    查询班级
    @GetMapping("/selectClasses")
    @ResponseBody
    @CrossOrigin
    public JSON selectClasses(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", classesService.selectClasses(0, 10000, null).size());
        json.put("data", classesService.selectClasses(page2, limit, null));
        return json;
    }

    //通过学院查找班级
    @GetMapping("/selectCollegeClass")
    @ResponseBody
    @CrossOrigin
    public List queryClassCollege(int collegeid) {
        return classesService.selectCollegeClass(collegeid);
    }

    //查询全部班级-->
    @GetMapping("/selectWhereClasses01")
    @ResponseBody
    @CrossOrigin
    public List<Class_View> selectWhereClasses01() {
        return classesService.selectwhereClasses();
    }

    //    关键词查找
    @GetMapping("/selectWhereClasses")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereClasses(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", classesService.selectClasses(0, 10000, Keyword).size());
        json.put("data", classesService.selectClasses(page2, limit, Keyword));
        return json;
    }

    //批量添加班级信息
    @PostMapping("/addAllClasses")
    @ResponseBody
    @CrossOrigin
    public JSON importAlumnis(MultipartFile file) {
        InputStream inputStream = null;
        //输入流
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        ParseExcel parser = new ParseExcel();
        //第二行开始读取
        int startRow = 1;
        List<String[]> result = null;
        try {
            result = parser.parseExcel(inputStream, suffix, startRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Classes classes = null;
        JSON json = null;
        System.out.println(result);
        for (String[] ss : result) {
            int num;
            classes = new Classes();
            classes.setClasses(num = Integer.parseInt(ss[0]));
            classes.setTeacherid(teacherMapper.queryTeacherinfoid(ss[1]).get(0).getTeacherid());
            classes.setMajorid(majorMapper.queryMajorinfoid(ss[2]).get(0).getMajorid());
            classes.setCollegeid(collegeMapper.queryCollegeinfoid(ss[3]).get(0).getCollegeid());
            //导入信息进入数据库
            json = classesService.addClasses(classes);
            //关闭流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
