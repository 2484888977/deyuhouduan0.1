package com.deyu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score_view {
    private int id;
    private String stuid;
    private String stuname;
    private String stusex;
    private int stuclass;
    private int opcollegeid;
    private String collegeinfo;
    private int opmajorid;
    private String majorinfo;
    private int opteacherid;
    private String teacherinfo;
    private String opusername;
    private String opname;
    private int opjurisdictionid;
    private String jurisdictioninfo;
    private int opclassid;
    private String opclassinfo;
    private int useropcollegeid;
    private String usercollegeinfo;
    private int opscoreclassid;
    private String scoreclassinfo;
    private int score;
    private int opstate;
    private String operationinfo;
    private int opscorefir;
    private String scoreinfo;
    private int opscoresec;
    private String scoresecinfo;
    private String ip;
    private String datetime;
}
