package com.deyu.mapper;

import com.deyu.pojo.Systemlog;
import com.deyu.pojo.Zlog_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SystemlogMapper {
    //查询系统操作日志/关键字查询
    List<Systemlog> querySystemlog(@Param("page")int page, @Param("limit")int limit, @Param("Keyword") String Keyword);
    //    学分操作日志查询
    List<Zlog_view> selectZlogview(@Param("page")int page, @Param("limit")int limit, @Param("Keyword") String Keyword);
    List<Zlog_view> selectZlogviewinfo(int id);
}
