package com.deyu.controller;

import com.deyu.pojo.Qxinfo;
import com.deyu.service.QxinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/QxinfoController")
public class QxinfoController {

    @Autowired
    private QxinfoServiceImpl qxinfoService;

    @GetMapping("/queryQxinfo")
    @ResponseBody
    @CrossOrigin
    public List queryQxinfo(){
        return qxinfoService.queryQxinfo();
    }

    @GetMapping("/queryQxinfoid")
    @ResponseBody
    @CrossOrigin
    public Qxinfo queryQxinfoid(String jurisdictioninfo){
        return qxinfoService.queryQxinfoid(jurisdictioninfo);
    }

}
