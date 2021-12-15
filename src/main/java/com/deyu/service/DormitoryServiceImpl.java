package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.DormitoryMapper;
import com.deyu.pojo.Dormitory;
import com.deyu.pojo.Dormitory_view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    //添加学生寝室
    @Override
    public JSON addDormitory(Dormitory dormitory) {
        JSONObject json = new JSONObject();
        int code = 0;
        int code1 = 1;
        if (dormitory.getDormitoryinfo().isEmpty()) {
            code1 = 0;
            json.put("msg", "请填写具体描述");
        }
        if (code1 == 1) {
            code = dormitoryMapper.addDormitory(dormitory);
            if (code == 1) {
                json.put("msg", "添加成功");
                json.put("code", 1);
            } else {
                json.put("msg", "添加失败");
                json.put("code", 0);
            }
            return json;
        } else {
            json.put("code", 0);
        }
        return json;
    }

    //修改寝室号
    @Override
    public JSON updateDormitory(Dormitory dormitory) {
        JSONObject json = new JSONObject();
        int code = 0;
        code = dormitoryMapper.updateDormitory(dormitory);
        if(code == 1){
            json.put("msg","提交成功");
            json.put("code",1);
        }else {
            json.put("msg","提交失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON deleteDormitory(int dormitoryid) {
        JSONObject json = new JSONObject();
        int code = 0;
        code = dormitoryMapper.deleteDormitory(dormitoryid);
        if(code == 1){
            json.put("msg","删除成功");
            json.put("code",1);
        }else {
            json.put("msg","删除失败");
            json.put("code",0);
        }
        return json;
    }
    //查看/关键字查询寝室

    @Override
    public List<Dormitory_view> selectDormitoryinfo(int page, int limit, String Keyword) {
        return dormitoryMapper.selectDormitoryinfo(page, limit, Keyword);
    }

    //查看/编辑
    @Override
    public List<Dormitory_view> queryDormitoryinfo(int dormitoryid) {
        return dormitoryMapper.queryDormitoryinfo(dormitoryid);
    }

    @Override
    public List<Dormitory_view> queryDormitoryinfoid(String apartmentinfo) {
        return dormitoryMapper.queryDormitoryinfoid(apartmentinfo);
    }

    @Override
    public List<Dormitory_view> queryDormitoryin(String dormitoryinfo) {
        return dormitoryMapper.queryDormitoryin(dormitoryinfo);
    }
}
