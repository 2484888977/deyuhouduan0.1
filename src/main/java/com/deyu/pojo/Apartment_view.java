package com.deyu.pojo;

public class Apartment_view {
    private int apartmentid;
    private String apartmentinfo;
    private int collegeid;
    private String collegeinfo;

    @Override
    public String toString() {
        return "Apartment_view{" +
                "apartmentid=" + apartmentid +
                ", apartmentinfo='" + apartmentinfo + '\'' +
                ", collegeid=" + collegeid +
                ", collegeinfo='" + collegeinfo + '\'' +
                '}';
    }

    public int getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(int apartmentid) {
        this.apartmentid = apartmentid;
    }

    public String getApartmentinfo() {
        return apartmentinfo;
    }

    public void setApartmentinfo(String apartmentinfo) {
        this.apartmentinfo = apartmentinfo;
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
