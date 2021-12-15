package com.deyu.mapper;


import com.deyu.pojo.Apartment;
import com.deyu.pojo.Apartment_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApartmentMapper {
    //添加公寓信息
    int  addApartment(Apartment apartment);
    //关键字查询
    List<Apartment_view> selectwhereApartment();
    //删除公寓信息
    int deleteApartment(@Param("apartmentid")int apartmentid);
    //查看/编辑
    List<Apartment_view> queryApartmentinfo(@Param("apartmentid")int apartmentid);
    List<Apartment_view> queryApartmentinfoid(@Param("apartmentinfo")String apartmentinfo);
    //修改公寓信息
    int updateApartment(Apartment apartment);
    //查找公寓信息
    List<Apartment_view> selectApartment(@Param("page")int page, @Param("limit")int limit,@Param("Keyword") String Keyword);
}
