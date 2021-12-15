package com.deyu.mapper;

import com.deyu.pojo.Teacher;
import com.deyu.pojo.Teacher_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    //添加教师
    int addTeacherInfo(Teacher teacher);
    //修改教师信息
    int updateTeacherInfo(Teacher teacher);
    //删除教师信息
    int deleteTeacherInfo(@Param("teacherid")int teacherid);
    //查看编辑
    List<Teacher_view> selectTeacher01(@Param("teacherid")int teacherid);
    //查询全部教师
    List<Teacher_view> selectTeacher();
    //通过学院查找辅导员
    List<Teacher_view> selectCollegeTeacher(@Param("collegeid")int collegeid);
    //查找教师信息
    List<Teacher_view> selectTeacherInfo(@Param("page")int page,@Param("limit")int limit,@Param("Keyword") String Keyword);
    //名称转id
    List<Teacher> queryTeacherinfoid(@Param("teacherinfo")String teacherinfo);
}
