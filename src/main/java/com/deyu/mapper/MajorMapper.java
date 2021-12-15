package com.deyu.mapper;

import com.deyu.pojo.Major;
import com.deyu.pojo.Major_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface MajorMapper {
    //添加专业
    int addMajorInfo(Major major);

    //修改专业
    int updateMajorInfo(Major major);

    //删除专业
    int deleteMajorInfo(@Param("majorid") int majorid);

    //查看编辑
    List<Major_view> queryMajor(@Param("majorid") int majorid);

    //通过学院查找专业
    List<Major_view> selectCollegeMajor(@Param("collegeid")int collegeid);
    //查看专业
    List<Major_view> selectMajorInfo(@Param("page") int page, @Param("limit") int limit,@Param("Keyword") String Keyword);

    //查看全部专业
    List<Major_view> selectMajor();
    //名称转id
    List<Major> queryMajorinfoid(@Param("majorinfo")String majorinfo);
}
