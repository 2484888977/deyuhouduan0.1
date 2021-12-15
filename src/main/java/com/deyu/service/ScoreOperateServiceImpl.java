package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.ScoreOperateMapper;
import com.deyu.mapper.StudentsMapper;
import com.deyu.pojo.*;
import com.deyu.util.Gettinginfor.GettingIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreOperateServiceImpl implements com.deyu.service.ScoreOperateService {
    @Autowired
    private ScoreOperateMapper scoreOperateMapper;
    @Autowired
    private StudentsServiceImpl studentsService;
    @Autowired
    private StudentsMapper studentsMapper;
    @Override
    public List<Score_view> queryScoreView(int page,int limit,String Keyword) {
        return scoreOperateMapper.queryScoreView(page,limit,Keyword);
    }
    @Override
    public List<Score_view> queryScoreViewinfo() {
        return scoreOperateMapper.queryScoreViewinfo();
    }
    @Override
    public Score_view queryScoreViewid(int id) {
        return scoreOperateMapper.queryScoreViewid(id);
    }
    @Override
    public List<Zlog_view> queryZlogview(int page, int limit, String Keyword) {
        return scoreOperateMapper.queryZlogview(page,limit,Keyword);
    }
    @Override
    public List<Zlog_view> queryZlogviewinfo() {
        return scoreOperateMapper.queryZlogviewinfo();
    }

    @Override
    public JSON editScoreoperation(Scoreoperation scoreoperation) {
        int code = 0;
        JSONObject json = new JSONObject();
        JSONObject json2 = studentsService.editStudentScore(scoreoperation.getId());
        if ((int)json2.get("code") == 1) {
            scoreoperation.setOpstate(6);
            code = scoreOperateMapper.editScoreoperation(scoreoperation);
            if (code == 1) {
                json.put("msg", "审核成功");
                json.put("code", 1);
            } else {
                json.put("msg", "审核失败");
                json.put("code", 0);
            }
        }else if((int)json2.get("code") == 2){
            json.put("msg", "审核失败-学分已超出限制范围");
            json.put("code", 0);
        }else if((int)json2.get("code") == 3){
            json.put("msg", "审核失败");
            json.put("code", 0);
        }
        return json;
    }

    @Override
    public JSON addScoreoperation(Scoreoperation scoreoperation, User user) {
        int code = 0;
        int code1 = 0;
        int code2 = 1;
        int score = 0;
        JSONObject json = new JSONObject();
        if(user.getJurisdiction()==7||user.getJurisdiction()==10){
            scoreoperation.setInfo(null);
            scoreoperation.setOthername(null);
            scoreoperation.setOtherstate(null);
            scoreoperation.setOthertime(null);
            scoreoperation.setOpstate(2);
            scoreoperation.setShibie("0");
            code1 = 1;
        }else {
            Students students = new Students();
            scoreoperation.setInfo(null);
            scoreoperation.setOthername(scoreoperation.getOpname());
            scoreoperation.setOtherstate("1");
            scoreoperation.setOthertime(scoreoperation.getDatetime());
            scoreoperation.setShibie("1");
            scoreoperation.setOpstate(1);
            Stu_view stu_view = studentsService.selectStudentDetails(scoreoperation.getStuid());
            if (scoreoperation.getOpscoreclass() == 1) {
                score = stu_view.getScore() + scoreoperation.getScore();
                if(score<=100&&score>=0){
                    stu_view.setScore(score);
                }else {
                    code2 = 0;
                }
            } else if (scoreoperation.getOpscoreclass() == 2) {
                score = stu_view.getScore() - scoreoperation.getScore();
                if(score<=100&&score>=0){
                    stu_view.setScore(score);
                }else {
                    code2 = 0;
                }
            }
            students.setS_id(stu_view.getS_id());
            students.setScore(stu_view.getScore());
            if(code2 == 1){
                code1 = studentsMapper.editStudentScore(students);
            }else {
                json.put("msg", "学分已超出限制范围");
            }
        }
        if(code1==1){
            scoreoperation.setIp(GettingIp.getIpAddress());
            code = scoreOperateMapper.addScoreoperation(scoreoperation);
        }
        if (code == 1) {
            json.put("msg", "操作成功");
            json.put("code", 1);
        } else {
            if(code2 == 0){
                json.put("msg", "学分已超出限制范围");
            }else {
                json.put("msg", "操作失败");
            }
            json.put("code", 0);
        }
        System.out.println(scoreoperation);
        return json;
    }
    //学生学分查询—学分加减记录
    @Override
    public List<Score_view> queryScoreViewStu(String stuid, String stuname) {
        return scoreOperateMapper.queryScoreViewStu(stuid,stuname);
    }

}
