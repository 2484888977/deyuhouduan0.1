package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.ScoresecMapper;
import com.deyu.pojo.Quanxian;
import com.deyu.pojo.Scoresec;
import com.deyu.pojo.Scoresec_view;
import com.deyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresecServiceImpl implements ScoresecService {
    @Autowired
    private ScoresecMapper scoresecMapper;


    //添加二级学分
    @Override
    public JSON addScoresec(Scoresec scoresec) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = scoresecMapper.addScoresec(scoresec);
            if (code == 1) {
                json.put("msg", "添加学分信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "添加学分信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //更改二级学分记录
    @Override
    public JSON updatScoresec(Scoresec scoresec) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = scoresecMapper.updatScoresec(scoresec);
            if (code == 1) {
                json.put("msg", "修改学分信息成功");
                json.put("code", 1);
            } else {
                json.put("msg", "修改学分信息失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //删除
    @Override
    public JSON deleteScoresec(int scoresecid) {
        JSONObject json = new JSONObject();
        try {
            int code = 0;
            code = scoresecMapper.deleteScoresec(scoresecid);
            if (code == 1) {
                json.put("msg", "删除成功");
                json.put("code", 1);
            } else {
                json.put("msg", "删除失败");
                json.put("code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常,请稍后再试");
            json.put("code", -1);
        }
        return json;
    }

    //查看二级学分记录
    @Override
    public List<Scoresec_view> selectScoresec(int page, int limit, String Keyword) {
        return scoresecMapper.selectScoresec(page, limit, Keyword);
    }

    //关键字查询
    @Override
    public List<Scoresec_view> selectWhereScoresec(String keyword) {
        return scoresecMapper.selectWhereScoresec(keyword);
    }

    //查看编辑
    @Override
    public List<Scoresec_view> queryScoresec(int scoresecid) {
        return scoresecMapper.queryScoresec(scoresecid);
    }

    //一二级查看
    @Override
    public List<Scoresec_view> queryallScoresec(int scorefirid) {
        return scoresecMapper.queryallScoresec(scorefirid);
    }

}
