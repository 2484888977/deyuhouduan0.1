package com.deyu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.ApartmentMapper;
import com.deyu.mapper.DormitoryMapper;
import com.deyu.pojo.Classes;
import com.deyu.pojo.Dormitory;
import com.deyu.pojo.Dormitory_view;
import com.deyu.service.ApartmentServiceImpl;
import com.deyu.service.DormitoryService;
import com.deyu.util.ParseExcel;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/DormitoryController")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private ApartmentMapper apartmentMapper;

    //添加学生寝室
    @GetMapping("/addDormitory")
    @ResponseBody
    @CrossOrigin
    public JSON addDormitory(Dormitory dormitory) {
        return dormitoryService.addDormitory(dormitory);
    }

    //修改寝室号
    @GetMapping("/updateDormitory")
    @ResponseBody
    @CrossOrigin
    public JSON updateDormitory(Dormitory dormitory) {
        return dormitoryService.updateDormitory(dormitory);
    }

    //删除寝室号
    @GetMapping("/deleteDormitory")
    @ResponseBody
    @CrossOrigin
    public JSON deleteDormitory(int dormitoryid) {
        return dormitoryService.deleteDormitory(dormitoryid);
    }

    ;

    //查询寝室
    @GetMapping("/selectDormitoryinfo")
    @ResponseBody
    @CrossOrigin
    public JSON selectDormitoryinfo(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", dormitoryService.selectDormitoryinfo(0, 100000, null).size());
        json.put("data", dormitoryService.selectDormitoryinfo(page2, limit, null));
        return json;
    }


    //    关键字查询寝室
    @GetMapping("/selectWhereDormitory")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereDormitory(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", dormitoryService.selectDormitoryinfo(0, 100000, Keyword).size());
        json.put("data", dormitoryService.selectDormitoryinfo(page2, limit, Keyword));
        return json;
    }

    ;

    //查看/编辑
    @GetMapping("/queryDormitoryinfo")
    @ResponseBody
    @CrossOrigin
    public List<Dormitory_view> queryDormitoryinfo(int dormitoryid) {
        return dormitoryService.queryDormitoryinfo(dormitoryid);
    }

    ;

    @GetMapping("/queryDormitoryinfoid")
    @ResponseBody
    @CrossOrigin
    public List<Dormitory_view> queryDormitoryinfoid(String apartmentinfo) {
        return dormitoryService.queryDormitoryinfoid(apartmentinfo);
    }

    ;

    @GetMapping("/queryDormitoryin")
    @ResponseBody
    @CrossOrigin
    public List<Dormitory_view> queryDormitoryin(String dormitoryinfo) {
        return dormitoryService.queryDormitoryin(dormitoryinfo);
    }

    //批量添加寝室号
    @PostMapping("/addAllDormitoryin")
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
        Dormitory dormitory = new Dormitory();
        JSON json = null;
        System.out.println(result);
        for (String[] ss : result) {
            dormitory.setDormitoryid(0);
            dormitory.setDormitoryinfo(ss[1]);
            dormitory.setApartmentid(apartmentMapper.queryApartmentinfoid(ss[0]).get(0).getApartmentid());
            //导入信息进入数据库
            json = dormitoryService.addDormitory(dormitory);
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
