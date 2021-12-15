package com.deyu.controller;

import com.alibaba.fastjson.JSON;
import com.deyu.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogServiceImpl logService;


    @PostMapping("/select")
    @ResponseBody
    public JSON select(int page, int limit) {
        return logService.selectLogInfo(page, limit);
    }


}