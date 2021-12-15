package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Scoresec;
import com.deyu.pojo.Scoresec_view;
import com.deyu.service.ScoresecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ScoresecController")
@Controller
public class ScoresecController {
    @Autowired
    private ScoresecService scoresecService;

    /**
     * 添加学分
     * @param scoresec
     * @return
     */
    @GetMapping("/addScoresec")
    @ResponseBody
    @CrossOrigin
    public JSON addScoresec(Scoresec scoresec){
        return scoresecService.addScoresec(scoresec);
    }

    /**
     * 更改学分
     * @param scoresec
     * @return
     */
    @GetMapping("/updatScoresec")
    @ResponseBody
    @CrossOrigin
    public JSON updatScoresec(Scoresec scoresec){
        return scoresecService.updatScoresec(scoresec);
    }

    /**
     * 删除
     * @param scoresecid
     * @return
     */
    @GetMapping("/deleteScoresec")
    @ResponseBody
    @CrossOrigin
    public JSON deleteScoresec(int scoresecid){
        return scoresecService.deleteScoresec(scoresecid);
    }

    /**
     * 查看二级学分
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectScoresec")
    @ResponseBody
    @CrossOrigin
    public JSON selectScoresec(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",scoresecService.selectScoresec(page2,limit,null).size());
        json.put("data",scoresecService.selectScoresec(0,100000,null));
        return json;
    }

    /**
     * 关键字查询
     * @param page
     * @param limit
     * @param Keyword
     * @return
     */
    @GetMapping("/selectWhereScoresec")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereScoresec(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",scoresecService.selectScoresec(page2,limit,Keyword).size());
        json.put("data",scoresecService.selectScoresec(0,100000,Keyword));
        return json;
    }

    /**
     * 查看编辑
     * @param scoresecid
     * @return
     */
    @GetMapping("/queryScoresec")
    @ResponseBody
    @CrossOrigin
    public List<Scoresec_view> queryScoresec(int scoresecid){
        return scoresecService.queryScoresec(scoresecid);
    }

    /**
     * 一二级查看
     * @param scorefirid
     * @return
     */
    @GetMapping("/queryallScoresec")
    @ResponseBody
    @CrossOrigin
    public List<Scoresec_view> queryallScoresec(int scorefirid){
        return scoresecService.queryallScoresec(scorefirid);
    }
}
