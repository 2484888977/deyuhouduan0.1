package com.deyu.pojo;

public class Scoreclass {
    private int classid;
    private String calssinfo;

    public Scoreclass(int classid, String calssinfo) {
        this.classid = classid;
        this.calssinfo = calssinfo;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getCalssinfo() {
        return calssinfo;
    }

    public void setCalssinfo(String calssinfo) {
        this.calssinfo = calssinfo;
    }

    public Scoreclass() {
        super();
    }
}
