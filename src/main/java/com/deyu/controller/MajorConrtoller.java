package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Major;
import com.deyu.pojo.Major_view;
import com.deyu.service.MajorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/MajorController")
public class MajorConrtoller {
    @Autowired
    private MajorServiceImpl majorService;

    /**
     * 添加接口
     * @param major
     * @return
     */
    @GetMapping("/addMajorInfo")
    @ResponseBody
    @CrossOrigin
    public JSON addMajorInfo(Major major){
        return majorService.addMajorInfo(major);
    }

    /**
     * 修改接口
     * @param major
     * @return
     */
    @GetMapping("/updateMajorInfo")
    @ResponseBody
    @CrossOrigin
    public JSON updateMajorInfo(Major major){
        return majorService.updateMajorInfo(major);
    }

    /**
     * 删除专业
     * @param majorid
     * @return
     */
    @GetMapping("/deleteMajorInfo")
    @ResponseBody
    @CrossOrigin
    public JSON deleteMajorInfo(int majorid){
        return majorService.deleteMajorInfo(majorid);
    }
    //查看编辑
    @GetMapping("/queryMajor")
    @ResponseBody
    @CrossOrigin
    public List<Major_view> queryMajor(int majorid){
        return majorService.queryMajor(majorid);
    }

    //查看全部专业
    @GetMapping("/selectMajor")
    @ResponseBody
    @CrossOrigin
    public List<Major_view> selectMajorInfo(){
        return majorService.selectMajor();
    }

    /**
     * 查找专业
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectMajorInfo")
    @ResponseBody
    @CrossOrigin
    public JSON selectMajorInfo(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1 =page -1;
        int page2 =page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",majorService.selectMajorInfo(0,100000,null).size());
        json.put("data",majorService.selectMajorInfo(page2,limit,null));
        return json;
    }
//    关键字查询
    @GetMapping("/selectWhereMajorInfo")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereMajorInfo(@RequestParam("page")int page,@RequestParam("limit")int limit, @RequestParam("Keyword") String Keyword){
        JSONObject json = new JSONObject();
        int page1 =page -1;
        int page2 =page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",majorService.selectMajorInfo(0,100000,Keyword).size());
        json.put("data",majorService.selectMajorInfo(page2,limit,Keyword));
        return json;
    }
    //通过学院查找专业
    @GetMapping("/selectCollegeMajor")
    @ResponseBody
    @CrossOrigin
    public List<Major_view> selectCollegeMajor(int collegeid){
        return majorService.selectCollegeMajor(collegeid);
    }

}
