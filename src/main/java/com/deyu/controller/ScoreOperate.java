package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Score_view;
import com.deyu.pojo.Scoreoperation;
import com.deyu.pojo.User;
import com.deyu.service.ScoreOperateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("ScoreOperate")
public class ScoreOperate {
    @Autowired
    ScoreOperateServiceImpl scoreOperateService;
    @GetMapping("/queryScoreView")
    @ResponseBody
    @CrossOrigin
    public JSON queryScoreView(@RequestParam("page")int page, @RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",scoreOperateService.queryScoreView(0, 100000,null).size());
        json.put("data",scoreOperateService.queryScoreView(page2, limit,null));
        return json;
    }
    @GetMapping("/queryScoreViewinfo")
    @ResponseBody
    @CrossOrigin
    public List<Score_view> queryScoreViewinfo(){
        return scoreOperateService.queryScoreViewinfo();
    }
    @GetMapping("/queryScoreViewid")
    @ResponseBody
    @CrossOrigin
    public Score_view queryScoreViewid(@RequestParam("id")int id){
        return scoreOperateService.queryScoreViewid(id);
    }
    @GetMapping("/selectwhereScoreView")
    @ResponseBody
    @CrossOrigin
    public JSON selectwhereScoreView(@RequestParam("page")int page, @RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1*limit;
        json.put("code",0);
        json.put("msg","");
        json.put("count",scoreOperateService.queryScoreView(0, 100000,Keyword).size());
        json.put("data",scoreOperateService.queryScoreView(page2, limit,Keyword));
        return json;
    }
    //学分操作加分减分
    @GetMapping("/addScoreoperation")
    @ResponseBody
    @CrossOrigin
    public JSON addScoreoperation(Scoreoperation scoreoperation, HttpSession session){
        session.getAttribute("login_session");
        User user = (User) session.getAttribute("login_session");
        return scoreOperateService.addScoreoperation(scoreoperation,user);
    }
    //学分操作审核
    @GetMapping("/editScoreoperation")
    @ResponseBody
    @CrossOrigin
    public JSON editScoreoperation(Scoreoperation scoreoperation){
        return scoreOperateService.editScoreoperation(scoreoperation);
    }
    //学生学分查询—学分加减记录
    @GetMapping("/queryScoreViewStu")
    @ResponseBody
    @CrossOrigin
    public List<Score_view> queryScoreViewStu(@RequestParam("stuid")String stuid, @RequestParam("stuname")String stuname){
        System.out.println(stuid);
        System.out.println(stuname);
        return scoreOperateService.queryScoreViewStu(stuid,stuname);
    }
}
