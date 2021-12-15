package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Zlog_view;
import com.deyu.service.StudentsServiceImpl;
import com.deyu.service.SystemlogService;
import com.deyu.service.SystemlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("SystemlogController")
public class SystemlogController {

    @Autowired
    private SystemlogServiceImpl systemlogService;

    @GetMapping("/selectSystemlog")
    @ResponseBody
    @CrossOrigin
    public JSON selectSystemlog(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", systemlogService.querySystemlog(0, 100000, null).size());
        json.put("data", systemlogService.querySystemlog(page2, limit, null));
        return json;
    }

    @GetMapping("/selectWhereSystemlog")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereSystemlog(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", systemlogService.querySystemlog(0, 100000, Keyword).size());
        json.put("data", systemlogService.querySystemlog(page2, limit, Keyword));
        return json;
    }

    // <!--    //    学分操作日志查询-->
    @GetMapping("/selectZlogview")
    @ResponseBody
    @CrossOrigin
    public JSON selectZlogview(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", systemlogService.selectZlogview(0, 100000, null).size());
        json.put("data", systemlogService.selectZlogview(page2, limit, null));
        return json;
    }

    //    关键字查询
    @GetMapping("/selectWhereZlogview")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereZlogview(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", systemlogService.selectZlogview(0, 100000, Keyword).size());
        json.put("data", systemlogService.selectZlogview(page2, limit, Keyword));
        return json;
    }

    @GetMapping("/queryZlogviewinfo")
    @ResponseBody
    @CrossOrigin
    public List<Zlog_view> queryZlogviewinfo(int id) {
        return systemlogService.selectZlogviewinfo(id);
    }

}
