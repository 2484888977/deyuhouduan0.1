package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.College;
import com.deyu.service.CollegeServiceImpl;
import com.deyu.util.aLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CollegeController")
public class CollegeController {

    @Autowired
    private CollegeServiceImpl collegeService;

    //    添加学院
    @aLog("添加学院")
    @GetMapping("/addCollegeinfo")
    @ResponseBody
    @CrossOrigin
    public JSON addCollegeinfo(College college) {
        return collegeService.addCollegeinfo(college);
    }

    //    删除学院
    @GetMapping("/deleteCollegeInfo")
    @ResponseBody
    @CrossOrigin
    public JSON deleteCollegeInf(int collegeid) {
        return collegeService.deleteCollegeInfo(collegeid);
    }

    //修改学院/部门
    @GetMapping("/updateCollegeInfo")
    @ResponseBody
    @CrossOrigin
    public JSON updateCollegeInfo(College college) {
        return collegeService.updateCollegeInfo(college);
    }
    //    查询部门/学院
    @GetMapping("/queryCollegeAll")
    @ResponseBody
    @CrossOrigin
    public List queryCollegeAll() {
        return collegeService.queryCollegeAll();
    }
    //        查看学院
    @GetMapping("/selectCollege")
    @ResponseBody
    @CrossOrigin
    public List selectCollege() {
        return collegeService.selectCollege();
    }

    //    学院id转名
    @GetMapping("/selectCollegeXY")
    @ResponseBody
    @CrossOrigin
    public List selectCollegeXY(int collegeid) {
        return collegeService.selectCollegeXY(collegeid);
    }

    //        查看部门
    @GetMapping("/selectCollege01")
    @ResponseBody
    @CrossOrigin
    public List selectCollege01() {
        return collegeService.selectCollege01();
    }

    //    部门id转名
    @GetMapping("/selectCollegeXY01")
    @ResponseBody
    @CrossOrigin
    public List selectCollegeXY01(int collegeid) {
        return collegeService.selectCollegeXY01(collegeid);
    }

    //id查询学院/部门
    @GetMapping("/selectCollegeX")
    @ResponseBody
    @CrossOrigin
    public List selectCollegeX(int collegeid) {
        return collegeService.selectCollegeX(collegeid);
    }
    //        查询学院
    @GetMapping("/selectCollegeInfo01")
    @ResponseBody
    @CrossOrigin
    public JSON selectCollegeInfo01(@RequestParam("page")int page, @RequestParam("limit")int limit) {
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",collegeService.selectCollegeInfo01(0, 100000,null).size());
        json.put("data",collegeService.selectCollegeInfo01(page2,limit,null));
        return json;
    }
    //关键字查询——学院
    @GetMapping("/selectwhereCollege01")
    @ResponseBody
    @CrossOrigin
    public JSON selectwhereCollege01(@RequestParam("page")int page, @RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",collegeService.selectCollegeInfo01(0,100000,Keyword).size());
        json.put("data",collegeService.selectCollegeInfo01(page2, limit,Keyword));
        return json;
    }

    //        查询部门
    @GetMapping("/selectCollegeInfo")
    @ResponseBody
    @CrossOrigin
    public JSON selectCollegeInfo(@RequestParam("page")int page, @RequestParam("limit")int limit) {
            JSONObject json = new JSONObject();
            int page1 = page-1;
            int page2 = page1*limit;
            json.put("code",0);
            json.put("msg","");
            json.put("count",collegeService.selectCollegeInfo(0, 100000,null).size());
            json.put("data",collegeService.selectCollegeInfo(page2,limit,null));
            return json;
    }
    //关键字查询——单位/部门名称
    @GetMapping("/selectwhereCollege")
    @ResponseBody
    @CrossOrigin
    public JSON selectwhereCollege(@RequestParam("page")int page, @RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",collegeService.selectCollegeInfo(0,100000,Keyword).size());
        json.put("data",collegeService.selectCollegeInfo(page2, limit,Keyword));
        return json;
    }
}


