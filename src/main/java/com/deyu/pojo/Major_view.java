package com.deyu.pojo;

public class Major_view {
    private int majorid;
    private String majorinfo;
    private int collegeid;
    private String collegeinfo;

    @Override
    public String toString() {
        return "Major_view{" +
                "majorid=" + majorid +
                ", majorinfo='" + majorinfo + '\'' +
                ", collegeid=" + collegeid +
                ", collegeinfo='" + collegeinfo + '\'' +
                '}';
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public String getMajorinfo() {
        return majorinfo;
    }

    public void setMajorinfo(String majorinfo) {
        this.majorinfo = majorinfo;
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
}
