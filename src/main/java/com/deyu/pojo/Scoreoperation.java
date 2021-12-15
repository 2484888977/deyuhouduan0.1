package com.deyu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scoreoperation {
    private int id;
    private String stuid;
    private String stuname;
    private String stusex;
    private String stuclass;
    private int opcollege;
    private int opmajor;
    private int opteacher;
    private String opusername;
    private int opjurisdiction;
    private String opname;
    private int opclass;
    private int opclassinfo;
    private int opscoreclass;
    private int score;
    private int opstate;
    private int opscorefir;
    private int opscoresec;
    private String datetime;
    private String ip;
    private String info;
    private String othername;
    private String otherstate;
    private String othertime;
    private String shibie;
}
