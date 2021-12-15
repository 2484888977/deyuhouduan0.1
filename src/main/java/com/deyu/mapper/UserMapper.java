package com.deyu.mapper;


import com.deyu.pojo.User;
import com.deyu.pojo.User_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //登录
    User login(User user);
    //个人信息-->查看/编辑--查看
    User_view queryUserInfo(@Param("u_id") int u_id);
    //操作——>查看/编辑——编辑
    int updateUser(User user);
    //个人信息---->保存
    int saveUserInfo(User user);
    //修改密码-----验证密码
    User verifyUserPwd(User user);
    //修改密码-----输入新密码-----重复输入新密码
    int updateUserPwd(User user);
    //添加用户
    int addUser(User user);
    //重置密码
    int resetUserPwd(@Param("u_id")int u_id,@Param("password") String password);
    //删除用户
    int deleteUser(@Param("u_id") int u_id);
    //查看用户
    List<User_view> queryUser(@Param("page")int page,@Param("limit")int limit,@Param("Keyword")String Keyword);
    //批量添加
    int addAllUser(User user);
}