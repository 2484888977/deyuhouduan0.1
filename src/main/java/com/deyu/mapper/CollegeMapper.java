package com.deyu.mapper;

import com.deyu.pojo.College;
import com.deyu.pojo.U_Colle_View;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeMapper {
//    查询部门/学院
    List<College> queryCollegeAll();
    //    添加学院
    int addCollegeinfo(College college);

    //     查看学院
    List<College> selectCollege();

    //    学院id转名
    List<College> selectCollegeXY(@Param("collegeid") int collegeid);

    //     查看部门
    List<College> selectCollege01();

    //    部门id转名
    List<College> selectCollegeXY01(@Param("collegeid") int collegeid);

    //    删除学院
    int deleteCollegeInfo(@Param("collegeid") int collegeid);

    //    修改学院
    int updateCollegeInfo(College college);

    //id查询学院/部门
    List<College> selectCollegeX(int collegeid);
    //    查询学院
    List<College> selectCollegeInfo01(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword);

    //    查询部门
    List<College> selectCollegeInfo(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword);
    //名称转id
    List<College> queryCollegeinfoid(@Param("collegeinfo")String collegeinfo);
}
