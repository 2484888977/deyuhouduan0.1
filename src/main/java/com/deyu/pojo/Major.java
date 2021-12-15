package com.deyu.pojo;

public class Major {
    private int majorid;
    private String majorinfo;
    private int collegeid;

    @Override
    public String toString() {
        return "Major{" +
                "majorid=" + majorid +
                ", majorinfo='" + majorinfo + '\'' +
                ", collegeid=" + collegeid +
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
}
