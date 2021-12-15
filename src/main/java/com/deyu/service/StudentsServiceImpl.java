package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.StudentsMapper;
import com.deyu.mapper.TeacherMapper;
import com.deyu.pojo.*;
import com.deyu.util.RegexMatches.RegexMatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private ScoreOperateServiceImpl scoreOperateService;
    @Autowired
    private TeacherMapper teacherMapper;

    //查看——学生详情

    @Override
    public Stu_view selectStudentDetails(String s_id) {
        return studentsMapper.selectStudentDetails(s_id);
    }

    //    批量添加班级信息
    @Override
    public JSON addAllStudent(Students students) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = studentsMapper.addAllStudent(students);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "添加学生信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "添加学生信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }

    @Override
    //添加学生
    public JSON addStudentsInfo(Students students) {
        JSONObject json = new JSONObject();
        int code = 0;
        int code1 = 1;

        if (students.getS_id().isEmpty()) {
            json.put("msg", "学号不能为空");
            code1 = 0;
        } else if (!RegexMatches.XuehaoVerify(students.getS_id())) {
            code1 = 0;
            json.put("msg", "学号格式不正确");
        } else if (studentsMapper.selectStudentDetails(students.getS_id()) != null) {
            code1 = 0;
            json.put("msg", "该学号学生已存在");
        }

        if (students.getS_name().isEmpty()) {
            json.put("msg", "姓名不能为空");
            code1 = 0;
        } else if (!RegexMatches.ChineseVerify(students.getS_name(), 2, 5)) {
            code1 = 0;
            json.put("msg", "请按照格式填写正确的姓名");
        }

        if (students.getS_proid().isEmpty()) {
            json.put("msg", "身份证号不能为空");
            code1 = 0;
        } else if (!RegexMatches.ProidVerify(students.getS_proid())) {
            code1 = 0;
            json.put("msg", "身份证号格式不正确");
        } else if (studentsMapper.queryStudentproid(students.getS_proid()) != null) {
            code1 = 0;
            json.put("msg", "该身份证号的学生已存在");
        }

        if (students.getS_class().isEmpty()) {
            json.put("msg", "请选择行政班");
            code1 = 0;
        }

        if (students.getS_room().isEmpty()) {
            json.put("msg", "请填写寝室号和床位");
            code1 = 0;
        } else if (!RegexMatches.ChuangweiVerify(students.getS_room())) {
            json.put("msg", "请按照格式填写正确的寝室号及床位");
            code1 = 0;
        }

        if (students.getApartment().isEmpty()) {
            json.put("msg", "请选择公寓楼号");
            code1 = 0;
        }

        if (students.getDormitory().isEmpty()) {
            json.put("msg", "请选择寝室号");
            code1 = 0;
        }

        if (students.getS_add().isEmpty()) {
            code1 = 0;
            json.put("msg", "手机号码不能为空");
        } else if (!RegexMatches.PhonenumberVerify(students.getS_add())) {
            code1 = 0;
            json.put("msg", "学生手机号码格式不正确");
        }

        if (!students.getS_dadname().isEmpty()) {
            if (!RegexMatches.ChineseVerify(students.getS_dadname(), 2, 5)) {
                code1 = 0;
                json.put("msg", "请按照格式填写正确的父亲姓名");
            }
        }

        if (!students.getS_mumname().isEmpty()) {
            if (!RegexMatches.ChineseVerify(students.getS_mumname(), 2, 5)) {
                code1 = 0;
                json.put("msg", "请按照格式填写正确的母亲姓名");
            }
        }

        if (!students.getS_dadadd().isEmpty()) {
            if (!RegexMatches.PhonenumberVerify(students.getS_dadadd())) {
                code1 = 0;
                json.put("msg", "父亲手机号码格式不正确");
            }
        }
        if (!students.getS_mumadd().isEmpty()) {
            if (!RegexMatches.PhonenumberVerify(students.getS_mumadd())) {
                code1 = 0;
                json.put("msg", "母亲手机号码格式不正确");
            }
        }
        students.setScore(60);
        if (code1 == 1) {
            code = studentsMapper.addStudentsInfo(students);
            if (code == 1) {
                json.put("msg", "添加成功");
                json.put("code", 1);
            } else {
                json.put("msg", "添加失败");
                json.put("code", 0);
            }
            return json;
        } else {
            json.put("code", 0);
        }
        return json;
    }

    //修改学生
    @Override
    public JSON updateStudentsInfo(Students students) {
        JSONObject json = new JSONObject();
        int code = 0;
        int code1 = 1;

        if (students.getS_add().isEmpty()) {
            code1 = 0;
            json.put("msg", "手机号码不能为空");
        } else if (!RegexMatches.PhonenumberVerify(students.getS_add())) {
            code1 = 0;
            json.put("msg", "学生手机号码格式不正确");
        }

        if (students.getS_name().isEmpty()) {
            json.put("msg", "姓名不能为空");
            code1 = 0;
        } else if (!RegexMatches.ChineseVerify(students.getS_name(), 2, 5)) {
            code1 = 0;
            json.put("msg", "请按照格式填写正确的姓名");
        }

        if (students.getS_room().isEmpty()) {
            json.put("msg", "请填写寝室号和床位");
            code1 = 0;
        } else if (!RegexMatches.ChuangweiVerify(students.getS_room())) {
            json.put("msg", "请按照格式填写正确的寝室号及床位");
            code1 = 0;
        }
//        if(!students.getS_add().isEmpty()){
//            if (!RegexMatches.PhonenumberVerify(students.getS_dadadd())) {
//                code1 = 0;
//                json.put("msg", "父亲手机号码格式不正确");
//            }
//        }
//        if(!students.getS_add().isEmpty()){
//            if (!RegexMatches.PhonenumberVerify(students.getS_mumadd())) {
//                code1 = 0;
//                json.put("msg", "母亲手机号码格式不正确");
//            }
//        }
        if (code1 == 1) {
            code = studentsMapper.updateStudentsInfo(students);
            if (code == 1) {
                json.put("msg", "提交成功");
                json.put("code", 1);
            } else {
                json.put("msg", "提交失败");
                json.put("code", 0);
            }
        } else {
            json.put("code", 0);
        }
        return json;
    }

    //查看——学生学分
    @Override
    public JSONObject queryStudentScore(String s_id, String s_proid) {
        JSONObject json = new JSONObject();
        Stu_view stu_view = new Stu_view();
        int code = 0;
        int code1 = 1;

        if (!RegexMatches.XuehaoVerify(s_id)) {
            code1 = 0;
            json.put("msg", "学号格式不正确");
        }

        if (!RegexMatches.ProidVerify(s_proid)) {
            code1 = 0;
            json.put("msg", "身份证号码格式不正确");
        }

        if (code1 == 1) {
            stu_view = studentsMapper.queryStudentScore(s_id, s_proid);
            if (stu_view != null) {
                code = 1;
            }
            if (code == 1) {
                json.put("stu", stu_view);
                json.put("msg", "查询成功");
                json.put("code", 1);
            } else {
                json.put("msg", "查询失败");
                json.put("code", 0);
            }
            return json;
        } else {
            json.put("code", 0);
        }
        return json;
    }

    //学生学分更改
    @Override
    public JSONObject editStudentScore(int id) {
        int score = 0;
        int code = 0;
        int code1 = 1;
        JSONObject json = new JSONObject();
        Students students = new Students();
        Score_view score_view = scoreOperateService.queryScoreViewid(id);
        Stu_view stu_view = studentsMapper.selectStudentDetails(score_view.getStuid());
        if (score_view.getOpscoreclassid() == 1) {
            score = stu_view.getScore() + score_view.getScore();
            if (score <= 100 && score >= 0) {
                stu_view.setScore(score);
            } else {
                code1 = 0;
            }
        } else if (score_view.getOpscoreclassid() == 2) {
            score = stu_view.getScore() - score_view.getScore();
            if (score <= 100 && score >= 0) {
                stu_view.setScore(score);
            } else {
                code1 = 0;
            }
        }
        students.setS_id(stu_view.getS_id());
        students.setScore(stu_view.getScore());
        if (code1 == 1) {
            code = studentsMapper.editStudentScore(students);
            if (code == 1) {
                json.put("msg", "学分更改成功");
                json.put("code", 1);
            } else {
                json.put("msg", "学分更改失败");
                json.put("code", 3);
            }
        } else {
            json.put("msg", "学分已超出限制范围");
            json.put("code", 2);
        }
        return json;
    }

    //删除学生
    @Override
    public JSON deleteStudentsInfo(String s_id) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = studentsMapper.deleteStudentsInfo(s_id);
            if (code == 1) {
                json.put("msg", "删除学生信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "删除学生信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }


    //查找学生

    @Override
    public List<Stu_view> selectStudentsInfo(int page, int limit, String Keyword, User user) {
        System.out.println(user);
        Quanxian quanxian = new Quanxian();
        quanxian = quanxianif(user);
        System.out.println(quanxian.getCode()+"++++++"+quanxian.getXianzhi());
        return studentsMapper.selectStudentsInfo(page, limit, Keyword,quanxian.getCode(),quanxian.getXianzhi());
    }
//    @Override
//    public List<Stu_view> selectStudentsInfo(int page, int limit, String Keyword) {
//        return studentsMapper.selectStudentsInfo(page, limit, Keyword);
//
//    }





    @Override
    public Quanxian quanxianif(User user) {
        JSONObject json = new JSONObject();
        Quanxian quanxian = new Quanxian();
        int jurisdiction = user.getJurisdiction();
        quanxian.setCode(0);
        switch (jurisdiction) {
            case 1:
                quanxian.setCode(0);
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                quanxian.setCode(4);
                quanxian.setXianzhi(user.getU_classinfo());//院长所在学院id
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                quanxian.setCode(6);
                quanxian.setXianzhi(teacherMapper.queryTeacherinfoid(user.getU_name()).get(0).getTeacherid());//教师id
                break;
            case 7:
                System.out.println("7");
                quanxian.setCode(7);
                quanxian.setXianzhi(Integer.parseInt(studentsMapper.queryStudentproid(user.getUser_id()).getS_class()));
                break;
            case 8:
                System.out.println("8");
                break;
            case 9:
                System.out.println("9");
                break;
            case 10:
                System.out.println("10");
                break;
            case 11:
                System.out.println("11");
                break;
        }
        return quanxian;
    }
}
