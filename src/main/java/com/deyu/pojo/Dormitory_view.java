package com.deyu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory_view {
    private String apartmentinfo;
    private int dormitoryid;
    private int apartmentid;
    private String dormitoryinfo;
}
