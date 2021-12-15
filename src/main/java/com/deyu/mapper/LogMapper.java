package com.deyu.mapper;


import com.deyu.pojo.Syslog;
import com.deyu.pojo.Zlog_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface LogMapper {
    int addLog(Syslog syslog);

    List selectLogInfo(@Param("page")int page,@Param("limit")int limit);

    int showCount();


}
