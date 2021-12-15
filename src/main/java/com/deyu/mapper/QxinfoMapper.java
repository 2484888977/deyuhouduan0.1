package com.deyu.mapper;

import com.deyu.pojo.Qxinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QxinfoMapper {
    //获取权限
    List<Qxinfo> queryQxinfo();
    //获取权限id
    Qxinfo queryQxinfoid(@Param("jurisdictioninfo")String jurisdictioninfo);
}
