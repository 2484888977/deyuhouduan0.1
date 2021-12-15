package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Scorefir_view;
import com.deyu.pojo.Scorefirst;
import com.deyu.service.ScorefirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ScorefirstController")
@Controller
public class ScorefirstController {
    @Autowired
    private ScorefirstService scorefirstService;

    /**
     * 添加学分记录
     * @param scorefirst
     * @return
     */
    @GetMapping("/addScorefirst")
    @ResponseBody
    @CrossOrigin
    public JSON addScorefirst(Scorefirst scorefirst){
        return scorefirstService.addScorefirst(scorefirst);
    }

    /**
     * 修改学分
     * @param scorefirst
     * @return
     */
    @GetMapping("/updateScore")
    @ResponseBody
    @CrossOrigin
    public JSON updateScore(Scorefirst scorefirst){
        return scorefirstService.updateScore(scorefirst);
    }

    /**
     * 删除学分记录
     * @param scoreid
     * @return
     */
    @GetMapping("/deleteScore")
    @ResponseBody
    @CrossOrigin
    public JSON deleteScore(int scoreid){
        return scorefirstService.deleteScore(scoreid);
    }

    /**
     * 查看学分
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/selectfirScore")
    @ResponseBody
    @CrossOrigin
    public JSON selectfirScore(@RequestParam("page")int page,@RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",scorefirstService.selectfirScore(page2,limit,null).size());
        json.put("data",scorefirstService.selectfirScore(0,100000,null));
        return json;
    }

    /**
     * 关键字查询
     * @param page
     * @param limit
     * @param Keyword
     * @return
     */
    @GetMapping("/selecrfirWhereScore")
    @ResponseBody
    @CrossOrigin
    public JSON selecrfirWhereScore(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword){
        JSONObject json = new JSONObject();
        int page1=page-1;
        int page2=page1*limit;
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("count",scorefirstService.selectfirScore(page2,limit,Keyword).size());
        json.put("data",scorefirstService.selectfirScore(0,100000,Keyword));
        return json;
    }

    /**
     * 查看编辑
     * @param scoreid
     * @return
     */
    @GetMapping("/queryScorefir")
    @ResponseBody
    @CrossOrigin
    public List<Scorefir_view> queryScorefir(int scoreid){
        return scorefirstService.queryScorefir(scoreid);
    }

    /**
     * 查看全部
     * @return
     */
    @GetMapping("/selectAll")
    @ResponseBody
    @CrossOrigin
    public List<Scorefir_view> selectAll(){
        return scorefirstService.selectAll();
    }
}
