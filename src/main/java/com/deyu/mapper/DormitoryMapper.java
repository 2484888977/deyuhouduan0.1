package com.deyu.mapper;


import com.deyu.pojo.Dormitory;
import com.deyu.pojo.Dormitory_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormitoryMapper {
    //修改寝室号
    int updateDormitory(Dormitory dormitory);

    //添加公寓楼号
    int addDormitory(Dormitory dormitory);

    //删除寝室号
    int deleteDormitory(int dormitoryid);

    //查看/关键字查询寝室
    List<Dormitory_view> selectDormitoryinfo(@Param("page") int page, @Param("limit") int limit, @Param("Keyword") String Keyword);

    //查看/编辑
    List<Dormitory_view> queryDormitoryinfo(@Param("dormitoryid") int dormitoryid);

    List<Dormitory_view> queryDormitoryinfoid(@Param("apartmentinfo") String apartmentinfo);

    List<Dormitory_view> queryDormitoryin(@Param("dormitoryinfo") String dormitoryinfo);
}
