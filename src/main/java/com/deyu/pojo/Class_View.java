package com.deyu.pojo;

public class Class_View {

    private  int classes ;
    private  int teacherid;
    private  int majorid;
    private  int collegeid;
    private  String collegeinfo;
    private  String teacherinfo;
    private  String majorinfo;

    @Override
    public String toString() {
        return super.toString();
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegeinfo() {
        return collegeinfo;
    }

    public void setCollegeinfo(String collegeinfo) {
        this.collegeinfo = collegeinfo;
    }

    public String getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(String teacherinfo) {
        this.teacherinfo = teacherinfo;
    }

    public String getMajorinfo() {
        return majorinfo;
    }

    public void setMajorinfo(String majorinfo) {
        this.majorinfo = majorinfo;
    }
}
