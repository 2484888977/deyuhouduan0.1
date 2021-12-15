package com.deyu.pojo;

public class Apartment {
    private int apartmentid;
    private String apartmentinfo;
    private int collegeid;

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentid=" + apartmentid +
                ", apartmentinfo='" + apartmentinfo + '\'' +
                ", collegeid=" + collegeid +
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
}
