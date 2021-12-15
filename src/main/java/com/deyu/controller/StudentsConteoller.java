package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.*;
import com.deyu.pojo.Classes;
import com.deyu.pojo.Stu_view;
import com.deyu.pojo.Students;
import com.deyu.pojo.User;
import com.deyu.service.StudentsServiceImpl;
import com.deyu.util.ParseExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Controller
@RequestMapping("StudentsController")
public class StudentsConteoller {
    @Autowired
    private StudentsServiceImpl studentsService;
    @Autowired
    private ApartmentMapper apartmentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    /**
     * 添加学生
     *
     * @param students
     * @return
     */
    @GetMapping("/addStudentsInfo")
    @ResponseBody
    @CrossOrigin
    public JSON addStudentsInfo(Students students) {
        return studentsService.addStudentsInfo(students);
    }

    //编辑——学生信息
    @GetMapping("/updateStudentsInfo")
    @ResponseBody
    @CrossOrigin
    public JSON updateStudentsInfo(Students students) {
        return studentsService.updateStudentsInfo(students);
    }

    //查看学生详情
    @GetMapping("/selectStudentDetails")
    @ResponseBody
    @CrossOrigin
    public Stu_view selectStudentDetails(String s_id) {
        return studentsService.selectStudentDetails(s_id);
    }

    //查看——学生学分
    @GetMapping("/queryStudentScore")
    @ResponseBody
    @CrossOrigin
    public JSONObject queryStudentScore(@RequestParam("s_id")String s_id, @RequestParam("s_proid")String s_proid){
        return studentsService.queryStudentScore(s_id,s_proid);
    }
    //删除学生
    @GetMapping("/deleteStudentsInfo")
    @ResponseBody
    @CrossOrigin
    public JSON deleteStudentsInfo(String s_id) {
        return studentsService.deleteStudentsInfo(s_id);
    }

    //查询学生
    @GetMapping("/selectStudents")
    @ResponseBody
    @CrossOrigin
    public JSON selectStudents(@RequestParam("page")int page,@RequestParam("limit")int limit,HttpSession session){
        session.getAttribute("login_session");
        User user = (User) session.getAttribute("login_session");
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",studentsService.selectStudentsInfo(0, 100000," ",user).size());
        json.put("data",studentsService.selectStudentsInfo(page2, limit," ",user));
        return json;
    }
//    public JSON selectStudents(@RequestParam("page") int page, @RequestParam("limit") int limit) {
//        JSONObject json = new JSONObject();
//        int page1 = page - 1;
//        int page2 = page1 * limit;
//        json.put("code", 0);
//        json.put("msg", "查询学生信息成功");
//        json.put("count", studentsService.selectStudentsInfo(0, 100000, null).size());
//        json.put("data", studentsService.selectStudentsInfo(0, 10, null));
//        return json;
//    }

    //关键字查询——学号、姓名、班级、辅导员、公寓楼号、寝室号
    @GetMapping("/selectWhereStudents")
    @ResponseBody
    @CrossOrigin
    public JSON selectwhereStudnets(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword,HttpSession session){
        session.getAttribute("login_session");
        User user = (User) session.getAttribute("login_session");
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",studentsService.selectStudentsInfo(0, 100000,Keyword,user).size());
        json.put("data",studentsService.selectStudentsInfo(page2, limit,Keyword,user));
        return json;
    }
//    public JSON selectWhereStudents(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("Keyword") String Keyword) {
//        JSONObject json = new JSONObject();
//        int page1 = page - 1;
//        int page2 = page1 * limit;
//        json.put("code", 0);
//        json.put("msg", "查询学生信息成功");
//        json.put("count", studentsService.selectStudentsInfo(0, 100000, Keyword).size());
//        json.put("data", studentsService.selectStudentsInfo(page2, limit, Keyword));
//        return json;
//    }
    //批量添加学生信息
    @PostMapping("/addAllStudent")
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
        Students students = new Students();
        JSON json = null;
        System.out.println(result);
        for (String[] ss : result) {
            System.out.println(ss);
            students.setS_id(ss[0]);//1
            students.setS_name(ss[1]);//1
            students.setS_proid(ss[2]);//1
            students.setS_sex(ss[3]);//1
            students.setS_class(ss[4]);//1
            students.setS_room(ss[5]);//1
            students.setS_add(ss[6]);//1
            students.setApartment(ss[7]);//1
            //通过String.valueOf(map.get(i).get(7))找到对应的s_apartment;
            students.setS_apartment(apartmentMapper.queryApartmentinfoid(ss[7]).get(0).getApartmentid());
            students.setDormitory(ss[8]);//1
            //通过String.valueOf(map.get(i).get(8))找到对应的s_dormitory;
            students.setS_dormitory(dormitoryMapper.queryDormitoryin(ss[8]).get(0).getDormitoryid());
            //通过String.valueOf(map.get(i).get(9))找到对应的collegeid;
            students.setCollegeid(collegeMapper.queryCollegeinfoid(ss[9]).get(0).getCollegeid());//2
            //通过String.valueOf(map.get(i).get(10))找到对应的majorid;
            students.setMajorid(majorMapper.queryMajorinfoid(ss[10]).get(0).getMajorid());//2
            //通过(int)map.get(i).get(11)找到对应的teacherid;
            students.setTeacherid(teacherMapper.queryTeacherinfoid(ss[11]).get(0).getTeacherid());//2
            //学分默认60
            students.setScore(60);
            //导入信息进入数据库
            json = studentsService.addAllStudent(students);
            System.out.println(json);
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
