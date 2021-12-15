package com.deyu.pojo;

public class Students {
    private String s_id;
    private String s_name;
    private String s_sex;
    private String s_proid;
    private String s_nation;
    private String s_add;
    private String s_home;
    private String s_dadname;
    private String s_dadadd;
    private String s_mumname;
    private String s_mumadd;
    private String s_class;
    private String s_room;
    private int collegeid;
    private int majorid;
    private int teacherid;
    private int score;
    private int s_apartment;
    private int s_dormitory;
    private String apartment;
    private String dormitory;
    private String openid;

    @Override
    public String toString() {
        return "Students{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_proid='" + s_proid + '\'' +
                ", s_nation='" + s_nation + '\'' +
                ", s_add='" + s_add + '\'' +
                ", s_home='" + s_home + '\'' +
                ", s_dadname='" + s_dadname + '\'' +
                ", s_dadadd='" + s_dadadd + '\'' +
                ", s_mumname='" + s_mumname + '\'' +
                ", s_mumadd='" + s_mumadd + '\'' +
                ", s_class='" + s_class + '\'' +
                ", s_room='" + s_room + '\'' +
                ", collegeid=" + collegeid +
                ", majorid=" + majorid +
                ", teacherid=" + teacherid +
                ", score=" + score +
                ", s_apartment=" + s_apartment +
                ", s_dormitory=" + s_dormitory +
                ", apartment='" + apartment + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_proid() {
        return s_proid;
    }

    public void setS_proid(String s_proid) {
        this.s_proid = s_proid;
    }

    public String getS_nation() {
        return s_nation;
    }

    public void setS_nation(String s_nation) {
        this.s_nation = s_nation;
    }

    public String getS_add() {
        return s_add;
    }

    public void setS_add(String s_add) {
        this.s_add = s_add;
    }

    public String getS_home() {
        return s_home;
    }

    public void setS_home(String s_home) {
        this.s_home = s_home;
    }

    public String getS_dadname() {
        return s_dadname;
    }

    public void setS_dadname(String s_dadname) {
        this.s_dadname = s_dadname;
    }

    public String getS_dadadd() {
        return s_dadadd;
    }

    public void setS_dadadd(String s_dadadd) {
        this.s_dadadd = s_dadadd;
    }

    public String getS_mumname() {
        return s_mumname;
    }

    public void setS_mumname(String s_mumname) {
        this.s_mumname = s_mumname;
    }

    public String getS_mumadd() {
        return s_mumadd;
    }

    public void setS_mumadd(String s_mumadd) {
        this.s_mumadd = s_mumadd;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getS_room() {
        return s_room;
    }

    public void setS_room(String s_room) {
        this.s_room = s_room;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getS_apartment() {
        return s_apartment;
    }

    public void setS_apartment(int s_apartment) {
        this.s_apartment = s_apartment;
    }

    public int getS_dormitory() {
        return s_dormitory;
    }

    public void setS_dormitory(int s_dormitory) {
        this.s_dormitory = s_dormitory;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
