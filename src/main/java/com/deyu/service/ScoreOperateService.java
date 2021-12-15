package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Score_view;
import com.deyu.pojo.Scoreoperation;
import com.deyu.pojo.User;
import com.deyu.pojo.Zlog_view;

import java.util.List;

public interface ScoreOperateService {
    List<Score_view> queryScoreView(int page, int limit, String Keyword);
    List<Score_view> queryScoreViewinfo();
    Score_view queryScoreViewid(int id);
    List<Zlog_view> queryZlogview(int page, int limit, String Keyword);
    List<Zlog_view> queryZlogviewinfo();
//    //学分操作审核记录
    JSON editScoreoperation(Scoreoperation scoreoperation);
    //添加学分操作申请记录
    JSON addScoreoperation(Scoreoperation scoreoperation, User user);
    //学生学分查询—学分加减记录
    List<Score_view> queryScoreViewStu(String stuid,String stuname);
}
