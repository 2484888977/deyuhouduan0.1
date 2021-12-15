package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyu.mapper.LogMapper;
import com.deyu.pojo.Syslog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int addLog(Syslog syslog) {
        return logMapper.addLog(syslog);
    }

    @Override
    public JSON selectLogInfo(int page, int limit) {
        JSONObject json = new JSONObject();
        List list = logMapper.selectLogInfo((page -1)*limit, limit);
        if (list != null){
            json.put("msg","查询成功");
            json.put("code",1);
            json.put("data",list);
            json.put("count",logMapper.showCount());
        }else {
            json.put("msg","查询失败");
            json.put("code",0);
            json.put("data",null);
            json.put("count",0);
        }
        return json;
    }
}
