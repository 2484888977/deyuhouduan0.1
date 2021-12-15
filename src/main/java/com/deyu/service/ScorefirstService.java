package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Scorefir_view;
import com.deyu.pojo.Scorefirst;

import java.util.List;

public interface ScorefirstService {
    //添加学分记录一级分类
    JSON addScorefirst(Scorefirst scorefirst);
    //修改学分
    JSON updateScore(Scorefirst scorefirst);
    //删除
    JSON deleteScore(int scoreid);
    //查看学分
    List<Scorefir_view> selectfirScore(int page,int limit,String Keyword);
    //关键字查询
    List<Scorefir_view> selecrfirWhereScore(String Keyword);
    //查看编辑
    List<Scorefir_view> queryScorefir(int scoreid);
    //查看全部
    List<Scorefir_view> selectAll();
}
