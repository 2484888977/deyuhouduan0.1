package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.ScorefirstMapper;
import com.deyu.pojo.Scorefir_view;
import com.deyu.pojo.Scorefirst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorefirstServiceImpl implements ScorefirstService{
    @Autowired
    private ScorefirstMapper scorefirstMapper;
    //添加学分记录一级分类
    @Override
    public JSON addScorefirst(Scorefirst scorefirst) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=scorefirstMapper.addScorefirst(scorefirst);
            if (code==1){
                json.put("msg","添加学分成功");
                json.put("code",1);
            }else {
                json.put("msg","添加学分失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常，稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //修改学分
    @Override
    public JSON updateScore(Scorefirst scorefirst) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=scorefirstMapper.updateScore(scorefirst);
            if (code==1){
                json.put("msg","修改学分成功");
                json.put("code",1);
            }else {
                json.put("msg","修改学分失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常，稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //删除
    @Override
    public JSON deleteScore(int scoreid) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=scorefirstMapper.deleteScore(scoreid);
            if (code==1){
                json.put("msg","删除成功");
                json.put("code",1);
            }else {
                json.put("msg","删除失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }
    //查找学分
    @Override
    public List<Scorefir_view> selectfirScore(int page, int limit, String Keyword) {
        return scorefirstMapper.selectfirScore(page, limit, Keyword);
    }
    //关键字查找
    @Override
    public List<Scorefir_view> selecrfirWhereScore(String Keyword) {
        return scorefirstMapper.selecrfirWhereScore(Keyword);
    }
    //查看编辑
    @Override
    public List<Scorefir_view> queryScorefir(int scoreid) {
        return scorefirstMapper.queryScorefir(scoreid);
    }
    //查看全部
    @Override
    public List<Scorefir_view> selectAll() {
        return scorefirstMapper.selectAll();
    }
}
