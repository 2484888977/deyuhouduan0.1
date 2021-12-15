package com.deyu.pojo;

public class Teacher {
    private int teacherid;
    private String teacherinfo;
    private int collegeid;
    private String teachersex;
    private String teacheradd;

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(String teacherinfo) {
        this.teacherinfo = teacherinfo;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getTeachersex() {
        return teachersex;
    }

    public void setTeachersex(String teachersex) {
        this.teachersex = teachersex;
    }

    public String getTeacheradd() {
        return teacheradd;
    }

    public void setTeacheradd(String teacheradd) {
        this.teacheradd = teacheradd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", teacherinfo='" + teacherinfo + '\'' +
                ", collegeid=" + collegeid +
                ", teachersex='" + teachersex + '\'' +
                ", teacheradd='" + teacheradd + '\'' +
                '}';
    }
}
