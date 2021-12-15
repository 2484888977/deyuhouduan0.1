package com.deyu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.pojo.Apartment;
import com.deyu.pojo.Apartment_view;
import com.deyu.service.ApartmentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ApartmentController")
public class ApartmentController {

    @Autowired
    private ApartmentServiceImpl apartmentService;

    @GetMapping("/addApartment")
    @ResponseBody
    @CrossOrigin
    public JSON addApartment(Apartment apartment) {
        return apartmentService.addApartment(apartment);
    }

    @GetMapping("/deleteApartment")
    @ResponseBody
    @CrossOrigin
    public JSON deleteApartment(int apartmentid) {
        return apartmentService.deleteApartment(apartmentid);
    }

    @GetMapping("/updateApartment")
    @ResponseBody
    @CrossOrigin
    public JSON updateUser(Apartment apartment) {
        return apartmentService.updateApartment(apartment);
    }

    //查看全部公寓
    @GetMapping("/queryApartment")
    @ResponseBody
    @CrossOrigin
    public List queryApartment1() {
        return apartmentService.selectwhereApartment();
    }

    //查看/编辑
    @GetMapping("/queryApartmentinfo")
    @ResponseBody
    @CrossOrigin
    public List<Apartment_view> queryApartmentinfo(int apartmentid) {
        return apartmentService.queryApartmentinfo(apartmentid);
    }

    ;

    @GetMapping("/queryApartmentinfoid")
    @ResponseBody
    @CrossOrigin
    public List<Apartment_view> queryApartmentinfoid(String apartmentinfo) {
        return apartmentService.queryApartmentinfoid(apartmentinfo);
    }

    ;

    //查看公寓
    @GetMapping("/selectApartment")
    @ResponseBody
    @CrossOrigin
    public JSON selectApartment(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "查询成功");
        json.put("count", apartmentService.selectApartment(0, 100000, null).size());
        json.put("data", apartmentService.selectApartment(page2, limit, null));
        return json;
    }

    //关键字查询公寓
    @GetMapping("/selectWhereApartment")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereApartment(@RequestParam("page") int page, @RequestParam("limit") int limit, @Param("Keyword") String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "查询成功");
        json.put("count", apartmentService.selectApartment(0, 100000, Keyword).size());
        json.put("data", apartmentService.selectApartment(page2, limit, Keyword));
        return json;
    }
}
