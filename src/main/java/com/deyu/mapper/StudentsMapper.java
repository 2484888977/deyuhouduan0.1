package com.deyu.mapper;

import com.deyu.pojo.Stu_view;
import com.deyu.pojo.Students;
import com.deyu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentsMapper {
    //添加学生
    int addStudentsInfo(Students students);
    //修改学生
    int updateStudentsInfo(Students students);
    //批量添加学生
    int addAllStudent(Students students);
    //查看——学生学分
    Stu_view queryStudentScore(@Param("s_id") String s_id, @Param("s_proid") String s_proid);
    //查看——学生详情
    Stu_view selectStudentDetails(@Param("s_id") String s_id);

    //学生学分更改
    int editStudentScore(Students students);
    //删除学生
    int deleteStudentsInfo(@Param("s_id")String s_id);

    //查找学生
//    List<Stu_view> selectStudentsInfo(@Param("page")int page,@Param("limit")int limit,@Param("Keyword") String Keyword);
    List<Stu_view> selectStudentsInfo(@Param("page")int page, @Param("limit")int limit,@Param("Keyword") String Keyword,int code,int xianzhi);

    //按照身份证查找，判断是否存在
    Stu_view queryStudentproid(@Param("s_proid")String s_proid);
}
