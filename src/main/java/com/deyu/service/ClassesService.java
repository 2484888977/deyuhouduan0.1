package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Class_View;
import com.deyu.pojo.Classes;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.javassist.compiler.ast.Keyword;

import java.util.List;

public interface ClassesService {

    //添加班级
    JSON addClasses(Classes classes);
    //批量添加班级信息
    JSON addAllClasses(String filepath);

    //删除班级
    JSON deleteClasses(int classes);

    //通过学院查找班级
    List<Class_View> selectCollegeClass(int collegeid);

    //关键字查询
    List<Class_View> selectwhereClasses();

    //查看/编辑
    List<Class_View> queryClassinfo(int classes);

    //修改班级
    JSON updataClasses(Classes classes);

    //查询班级
    List<Class_View> selectClasses(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword);
//    List<Class_View> selectClasses(int page,int limit);
}
