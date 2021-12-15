package com.deyu.pojo;

public class College {
    private int collegeid;
    private String collegeinfo;
    private  String userclass;

    @Override
    public String toString() {
        return "College{" +
                "collegeid=" + collegeid +
                ", collegeinfo='" + collegeinfo + '\'' +
                ", userclass='" + userclass + '\'' +
                '}';
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

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }
}
