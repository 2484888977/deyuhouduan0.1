package com.deyu.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Syslog {
    private int id;
    private String name;
    private String account;
    private String time;
    private String content;
    private String requestIp;
    public Syslog(int id, String name, String account, String content, String requestIp) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
        this.content = content;
        this.requestIp = requestIp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    @Override
    public String toString() {
        return "Syslog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", requestIp='" + requestIp + '\'' +
                '}';
    }
}
