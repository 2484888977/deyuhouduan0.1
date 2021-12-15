package com.deyu.service;

import com.alibaba.fastjson.JSON;
import com.deyu.pojo.Apartment;
import com.deyu.pojo.Apartment_view;

import java.util.List;


public interface ApartmentService {
    //关键字查询
    List<Apartment_view> selectwhereApartment();

    //查看/编辑
    List<Apartment_view> queryApartmentinfo(int apartmentid);

    List<Apartment_view> queryApartmentinfoid(String apartmentinfo);

    JSON addApartment(Apartment apartment);

    JSON deleteApartment(int apartmentid);

    JSON updateApartment(Apartment apartment);

    //    查询公寓/关键字查询
    List<Apartment_view> selectApartment(int page, int limit,String Keyword);
}
