package com.deyu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory {
    private int dormitoryid;
    private int apartmentid;
    private String dormitoryinfo;
}
