package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Quanxian;
import com.deyu.pojo.Scoresec;
import com.deyu.pojo.Scoresec_view;
import com.deyu.pojo.User;

import java.util.List;

public interface ScoresecService {
    //添加二级学分
    JSON addScoresec(Scoresec scoresec);
    //更改二级学分记录
    JSON updatScoresec(Scoresec scoresec);
    //删除
    JSON deleteScoresec(int scoresecid);
    //查看二级学分记录
    List<Scoresec_view> selectScoresec(int page, int limit, String Keyword);
    //关键字查询
    List<Scoresec_view> selectWhereScoresec(String keyword);
    //查看编辑
    List<Scoresec_view> queryScoresec(int scoresecid);
    //一二级查看
    List<Scoresec_view> queryallScoresec(int scorefrid);

}
