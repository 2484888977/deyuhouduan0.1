package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.MajorMapper;
import com.deyu.pojo.Major;
import com.deyu.pojo.Major_view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public JSON addMajorInfo(Major major) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = majorMapper.addMajorInfo(major);
            if (code == 1) {
                json.put("msg", "添加专业信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "添加专业信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    @Override
    public JSON updateMajorInfo(Major major) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = majorMapper.updateMajorInfo(major);
            if (code == 1) {
                json.put("msg", "修改专业信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "修改专业信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    @Override
    public JSON deleteMajorInfo(int id) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = majorMapper.deleteMajorInfo(id);
            if (code == 1) {
                json.put("msg", "删除专业信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "删除专业信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //    查看编辑
    @Override
    public List<Major_view> queryMajor(int majorid) {
        return majorMapper.queryMajor(majorid);
    }

    //通过学院查找专业
    @Override
    public List<Major_view> selectCollegeMajor(int collegeid) {
        return majorMapper.selectCollegeMajor(collegeid);
    }

    //查看全部专业

    @Override
    public List<Major_view> selectMajor() {
        return majorMapper.selectMajor();
    }

    //查看专业
    @Override
    public List<Major_view> selectMajorInfo(int page, int limit, String Keyword) {
        return majorMapper.selectMajorInfo(page, limit, Keyword);
    }
}
