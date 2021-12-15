package com.deyu.mapper;


import com.deyu.pojo.Class_View;
import com.deyu.pojo.Classes;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassesMapper {
    //添加班级
    int addClasses(Classes classes);
    //批量添加班级信息
    int addAllClasses(List<Classes> list);
    //通过学院查找班级
    List<Class_View> selectCollegeClass(@Param("collegeid") int collegeid);

    //删除班级
    int deleteClasses(@Param("classes") int classes);

    //修改班级
    int updataClasses(Classes classes);

    //查看/编辑
    List<Class_View> queryClassinfo(@Param("classes") int classes);

    //关键字查询
    List<Class_View> selectwhereClasses();

    //查询班级
    List<Class_View> selectClasses(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword);
}
