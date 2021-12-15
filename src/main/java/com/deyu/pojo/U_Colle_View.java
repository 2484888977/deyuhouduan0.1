package com.deyu.pojo;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class U_Colle_View {
    private int u_id;
    private String username;
    private String password;
    private String u_mail;
    private String u_name;
    private String u_sex;
    private String u_add;
    private int u_class;
    private int u_classinfo;
    private int jurisdiction;
    private String jurisdictioninfo;
    private String stateCode;
    private String info;
    private String user_id;
    private String address;
    private String qq;
    private String vx;
    private String del;
    private String openid;
    private int apartmentid;
    private String collegeinfo;
    private String userclass;

    @Override
    public String toString() {
        return "U_Colle_View{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", u_mail='" + u_mail + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_sex='" + u_sex + '\'' +
                ", u_add='" + u_add + '\'' +
                ", u_class=" + u_class +
                ", u_classinfo=" + u_classinfo +
                ", jurisdiction=" + jurisdiction +
                ", jurisdictioninfo='" + jurisdictioninfo + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", info='" + info + '\'' +
                ", user_id='" + user_id + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", vx='" + vx + '\'' +
                ", del='" + del + '\'' +
                ", openid='" + openid + '\'' +
                ", apartmentid=" + apartmentid +
                ", collegeinfo='" + collegeinfo + '\'' +
                ", userclass='" + userclass + '\'' +
                '}';
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getU_mail() {
        return u_mail;
    }

    public void setU_mail(String u_mail) {
        this.u_mail = u_mail;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_add() {
        return u_add;
    }

    public void setU_add(String u_add) {
        this.u_add = u_add;
    }

    public int getU_class() {
        return u_class;
    }

    public void setU_class(int u_class) {
        this.u_class = u_class;
    }

    public int getU_classinfo() {
        return u_classinfo;
    }

    public void setU_classinfo(int u_classinfo) {
        this.u_classinfo = u_classinfo;
    }

    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getJurisdictioninfo() {
        return jurisdictioninfo;
    }

    public void setJurisdictioninfo(String jurisdictioninfo) {
        this.jurisdictioninfo = jurisdictioninfo;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getVx() {
        return vx;
    }

    public void setVx(String vx) {
        this.vx = vx;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(int apartmentid) {
        this.apartmentid = apartmentid;
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
